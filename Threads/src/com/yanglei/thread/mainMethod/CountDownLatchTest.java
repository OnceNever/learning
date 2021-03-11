package com.yanglei.thread.mainMethod;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName: CountDownLatchTest
 * @Description: TODO 多线程之线程计数器 CountDownLatch 用法  类似于Thread的join()方法 但更灵活
 *               await();  countDown();
 * @Author: Yanglei
 * @Date: 2021/3/11 14:26
 * @Version: V1.0
 */
public class CountDownLatchTest {
    final static CountDownLatch latch = new CountDownLatch(5);
    //final static CountDownLatch latch = new CountDownLatch(2);
    //1.这种情况下和join()方法效果一致
    /*public static void main(String[] args) {
        int num = 2;
        for (int i = 0; i < 2; i++) {
            new MyThread(i, latch).start();
        }
        System.out.println("等待"+num+"个子线程执行完毕...");
        try {
            //线程计数器不为0时等待
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(num+"个子线程已经执行完毕");
        System.out.println("继续执行主线程");
    }*/

    //2.如果有六个线程(主线程除外)，每个线程都有两个执行步骤，第六个线程需要在前五个线程执行完第一阶段之后开始执行
    //这种情况下join()方法就不适用了，因为它需要等待整个线程执行完毕。
    // CountDownLatch就显得更加灵活，在5个线程第一阶段执行完毕之后调用 countDown() 方法
    public static void main(String[] args) {
        int num = 5;
        for (int i = 0; i < num; i++) {
            new MyThread(i, latch).start();
        }
        Thread t6 = new MyThread(6, latch);
        System.out.println("等待5个子线程第一阶段执行完毕...");
        try {
            //线程计数器不为0则一直等待
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t6.start();
    }
}
