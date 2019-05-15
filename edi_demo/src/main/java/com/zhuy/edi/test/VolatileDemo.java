package com.zhuy.edi.test;

/**
 * @Classname VolatileDemo
 * @Description TODO
 * @Date 2019/5/14 16:12
 * @Created by  zhuy
 */
public class VolatileDemo {
    public volatile static boolean stop = false;

    public static void main(String[] args) throws
            InterruptedException {
        Thread thread = new Thread(() -> {
            int i = 0;
            while (!stop) {
                i++;
            }
        });
        thread.start();
        System.out.println("begin start thread");
        Thread.sleep(1000);
        stop = true;
    }
}
