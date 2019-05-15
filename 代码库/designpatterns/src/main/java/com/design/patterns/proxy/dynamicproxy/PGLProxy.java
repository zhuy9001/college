package com.design.patterns.proxy.dynamicproxy;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class PGLProxy {


    public static final String ln = "\r\n";
    private static Map<Class, Class> mappings = new HashMap<Class, Class>();

    static {
        mappings.put(int.class, Integer.class);
    }


    public static Object newProxyInstance(PGLClassLoader classLoader, Class<?>[] interfaces, PGLInvocationHandler h) {

        try {
            String clazzStr = generateClazzStr(interfaces);
            System.out.println(clazzStr);
            //2、Java文件输出磁盘
            String filePath = PGLProxy.class.getResource("").getPath();
//           System.out.println(filePath);
            File f = new File(filePath + "$Proxy0.java");
            FileWriter fw = new FileWriter(f);
            fw.write(clazzStr);
            fw.flush();
            fw.close();

            //3、把生成的.java文件编译成.class文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manage = compiler.getStandardFileManager(null, null, null);
            Iterable iterable = manage.getJavaFileObjects(f);

            JavaCompiler.CompilationTask task = compiler.getTask(null, manage, null, null, null, iterable);
            task.call();
            manage.close();

            //4、编译生成的.class文件加载到JVM中来
            Class proxyClass = classLoader.findClass("$Proxy0");
            Constructor c = proxyClass.getConstructor(PGLInvocationHandler.class);
            f.delete();

            //5、返回字节码重组以后的新的代理对象
            return c.newInstance(h);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 这里只是将JDK动态代理实现原理初步实现，还有很多逻辑没有加上 ，比如多个接口的实现、接口数量的限制。看到JDK源码是对数量做了限制，最大接口数位65535
     * 原因是class文件中的interfaces 只占用u2 2个字节空间，每个字节存放2位16进制数据，所以最大只能有65535
     * @param interfaces
     * @return
     */
    private static String generateClazzStr(Class<?>[] interfaces) {

        StringBuffer sb = new StringBuffer();
        sb.append("package com.design.patterns.proxy.dynamicproxy;" + ln);
        sb.append("import java.lang.reflect.*;" + ln);
        int i = 0;
        Class clazz = interfaces[i];
        String clazzName = clazz.getName();
        //String packageName = clazz.getPackage().getName() + "." + clazzName;
        String newClazzName = "$Proxy" + i;
        sb.append("import " + clazzName + ";" + ln);
        sb.append("public class " + newClazzName + " implements " + clazzName + " {" + ln);
        sb.append(" PGLInvocationHandler h;" + ln);
        sb.append(" public " + newClazzName + "(PGLInvocationHandler h){" + ln);
        sb.append("this.h=h;" + ln);
        sb.append("}" + ln);
        for (Method m : clazz.getMethods()) {
            Class<?>[] params = m.getParameterTypes();
            StringBuffer paramNames = new StringBuffer();
            StringBuffer paramValues = new StringBuffer();
            StringBuffer paramClasses = new StringBuffer();

            for (int n = 0; n < params.length; n++) {
                Class paramsClazz = params[n];
                String type = paramsClazz.getName();
                String paramName = toLowerFirstCase(paramsClazz.getSimpleName());
                paramNames.append(type + " " + paramName);
                paramValues.append(paramName);
                paramClasses.append(paramsClazz.getName() + ".class");
                if (n > 0 && n < params.length - 1) {
                    paramNames.append(",");
                    paramClasses.append(",");
                    paramValues.append(",");
                }
            }
            sb.append("public " + m.getReturnType().getName() + " " + m.getName() + "(" + paramNames.toString() + ") {" + ln);
            sb.append("try{" + ln);
            sb.append("Method m = " + clazzName + ".class.getMethod(\"" + m.getName() + "\",new Class[]{" + paramClasses.toString() + "});" + ln);
            sb.append((hasReturnValue(m.getReturnType()) ? "return " : "") + getCaseCode("this.h.invoke(this,m,new Object[]{" + paramValues + "})", m.getReturnType()) + ";" + ln);
            sb.append("}catch(Error _ex) { }");
            sb.append("catch(Throwable e){" + ln);
            sb.append("throw new UndeclaredThrowableException(e);" + ln);
            sb.append("}");
            sb.append(getReturnEmptyCode(m.getReturnType()));
            sb.append("}");
        }
        sb.append("}");

        //  for (int i = 0; i < interfaces.length; i++)


        return sb.toString();
    }


    private static String getReturnEmptyCode(Class<?> returnClass) {
        if (mappings.containsKey(returnClass)) {
            return "return 0;";
        } else if (returnClass == void.class) {
            return "";
        } else {
            return "return null;";
        }
    }

    private static String getCaseCode(String code, Class<?> returnClass) {
        if (mappings.containsKey(returnClass)) {
            return "((" + mappings.get(returnClass).getName() + ")" + code + ")." + returnClass.getSimpleName() + "Value()";
        }
        return code;
    }

    private static boolean hasReturnValue(Class<?> clazz) {
        return clazz != void.class;
    }

    private static String toLowerFirstCase(String src) {
        char[] chars = src.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }

}
