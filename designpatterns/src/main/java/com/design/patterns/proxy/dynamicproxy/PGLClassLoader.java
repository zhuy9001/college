package com.design.patterns.proxy.dynamicproxy;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

public class PGLClassLoader  extends  ClassLoader{

    private File  classPathFile;

    public PGLClassLoader() {
        String classPath=PGLClassLoader.class.getResource("").getPath();
        this.classPathFile = new File(classPath);
    }


    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String className=PGLClassLoader.class.getPackage().getName()+"."+name;
        if(classPathFile!=null){
            File classFile=new File(classPathFile,name.replaceAll("\\.","/")+".class");
            if(classFile.exists()){
                FileInputStream in=null;
                ByteArrayOutputStream out=null;
                try {
                    in=new FileInputStream(classFile);
                    out=new ByteArrayOutputStream();
                    byte[] buff=new byte[1024];
                    int len=0;
                    while ((len=in.read(buff))!=-1){
                        out.write(buff,0,len);
                    }
                    return defineClass(className,out.toByteArray(),0,out.size());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }

        return null;
    }
}
