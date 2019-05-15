package com.zhuy.edi;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zhuy.edi.model.Order;
import com.zhuy.edi.model.RespModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Classname ThreadDemo
 * @Description
 * @Date 2019/5/14 10:16
 * @Created by  zhuy
 */
public class ThreadDemo {

    private Map<String, List<Order>> orderMap = new ConcurrentHashMap<>();
    private static Logger logger = LoggerFactory.getLogger(ThreadDemo.class);

    private static final String URL="URL";

    public void doImportAction(String... paramArr) throws Exception {
        boolean multipuleThread = false;
        try {
            if (paramArr != null) {
                for (String param : paramArr) {
                    if (param.toUpperCase().indexOf("POOL") >= 0 && param.toUpperCase().indexOf(":") > 0) {
                        multipuleThread = true;
                        break;
                    }
                }
            }
        } catch (Exception e) {
            logger.error("输入的运行参数（POOL）错误。", e);
        }

        if (multipuleThread) {
            doImportActionMultipuleThread(paramArr);
        }else {
            doImportActionSingle(paramArr);
        }
    }

    private void doImportActionSingle(String[] paramArr)  throws  Exception{
        String respContent = null;
        try {
            respContent = this.responseInfo(URL,3);
        } catch (Exception e) {
            logger.error("访问Order接口出错，错误信息：" + e.getMessage(), e);
            throw new Exception("访问Order接口出错，错误信息：" + e.getMessage());
        }
        if (respContent != null && respContent.trim().length() > 0) {
            doImportAction(respContent, true, paramArr);
        }
    }

    private String responseInfo(String url, int i) {

        return null;
    }

    /**
     * 多线程获取订单数据
     * @param paramArr
     */
    private void doImportActionMultipuleThread(String[] paramArr)  throws  Exception{
        orderMap.clear();
        int 	poolSize = 5;
        try {
            if (paramArr != null) {
                for (String param : paramArr) {
                    if (param.toUpperCase().indexOf("POOL") >= 0 && param.toUpperCase().indexOf(":") > 0) {
                        String[] tmpArr = param.split(":");
                        poolSize = Integer.parseInt(tmpArr[1].trim());
                    }
                }
            }

        } catch (Exception e) {
            logger.error("输入的运行参数（POOL）错误。", e);
        }

        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(poolSize);
        for (int i = 0; i < poolSize; i++) {
            AccessOrderApiThread accessOrderApiThread = new AccessOrderApiThread(i + 1);
            fixedThreadPool.execute(accessOrderApiThread);
            Thread.sleep(10);
        }
        fixedThreadPool.shutdown();
        while (true) {
            if (fixedThreadPool.isTerminated()) {
                logger.info("多线程访问Order接口结束，线程数：" + poolSize + " 获取订单数量：" + orderMap.size());
                break;
            }
            Thread.sleep(500);
        }
        if (!orderMap.isEmpty()) {
            List<Order> contentList = new ArrayList<Order>();
            int totalCount = 0;
            for (List<Order> tmpList : orderMap.values()) {
                contentList.addAll(tmpList);
                totalCount += tmpList.size();
            }
            logger.info("本次查询成功获取到Order信息。 获取Order数量：" + totalCount + "。");
        }
    }


    protected void doImportAction(String respContent, boolean flag, String[] paramArr) {

    }




    class AccessOrderApiThread implements Runnable {

        private int index;

        public AccessOrderApiThread(int index) {
            this.index = index;
        }

        @Override
        public void run() {
            try {
                String respContent = this.responseInfo(1);
                RespModel respModel= JSON.parseObject(respContent,RespModel.class);
                if(respModel!=null){
                    List<Order> orders=respModel.getOrders();
                    orderMap.put(String.valueOf(index),orders);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /**
         模拟访问客户API获取订单数据
         * @param tryTimes 重试多少次
         * @return
         * @throws Exception
         */
        private String responseInfo(int tryTimes)throws Exception{

            return null;
        }
    }
}
