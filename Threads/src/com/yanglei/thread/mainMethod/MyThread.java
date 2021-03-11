package com.yanglei.thread.mainMethod;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName: MyThread
 * @Description: TODO
 * @Author: Yanglei
 * @Date: 2021/3/11 14:29
 * @Version: V1.0
 */
public class MyThread extends Thread{
    int num;
    CountDownLatch latch;
    public MyThread(int num, CountDownLatch latch){
        this.num = num;
        this.latch = latch;
    }

    /*@Override
    public void run() {
        System.out.println("线程" + num + "正在执行...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程" + num + "执行完毕...");
        latch.countDown();
    }*/

    @Override
    public void run() {
        System.out.println("线程" + num + "开始执行第一阶段...");
        try {
            Thread.sleep((long)(5000 * Math.random()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程" + num + "第一阶段执行完毕...");
        latch.countDown();
        System.out.println("线程"+ num +"开始执行第二阶段...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程" + num + "第二阶段执行完毕...");
    }
}
