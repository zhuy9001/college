package com.zhuy.edi.test;

import java.net.HttpRetryException;
import java.util.concurrent.TimeUnit;

/**
 * @Classname InterruptDemo
 * @Description TODO
 * @Date 2019/5/14 15:47
 * @Created by  zhuy
 */
public class InterruptDemo {

    private  static  int i=0;

    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread(()->{
            while (true){
                if (Thread.currentThread().isInterrupted()){
                    System.out.println("before:"+Thread.currentThread().isInterrupted());
                    Thread.interrupted(); // 对线程进行复位，由 true 变成 false
                    System.out.println("after:"+Thread.currentThread().isInterrupted());
                }
            }
        },"interruptDemo");
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();
    }

}
