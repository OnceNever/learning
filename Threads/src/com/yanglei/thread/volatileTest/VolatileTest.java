package com.yanglei.thread.volatileTest;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName: VolatileTest
 * @Description: TODO volatile关键字
 * volatile 适合这种场景：一个变量被多个线程共享，线程直接给这个变量赋值。
 * @Author: Yanglei
 * @Date: 2021/3/11 16:02
 * @Version: V1.0
 */
public class VolatileTest {
    static volatile int num = 0;
    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(20);
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    num = (int)(Math.random()*10);
                    System.out.println("写入num的值为:"+num);
                    latch.countDown();
                }
            }).start();
        }
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("读取num的值为:"+num);
                    latch.countDown();
                }
            }).start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
