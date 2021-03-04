package com.yanglei.thread.sync;

import com.yanglei.thread.Hero;

/**
 * @ClassName: ThreadTest
 * @Description: TODO 测试多线程同步问题 分别启动100个线程给英雄加血和扣血
 * @Author: Yanglei
 * @Date: 2021/3/3 17:06
 * @Version: V1.0
 */
public class ThreadTest {
    public static void main(String[] args) {

        final Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 1000;

        int n = 1000;

        Thread[] addThreads = new Thread[n];
        Thread[] reduceThreads = new Thread[n];

        for (int i = 0; i < n; i++) {
            Thread t = new Thread(){
                public void run(){

                    //任何线程要修改hp的值，必须先占用someObject
                    synchronized (gareen) {
                        gareen.recover();
                    }

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            };
            t.start();
            addThreads[i] = t;

        }

        for (int i = 0; i < n; i++) {
            Thread t = new Thread(){
                public void run(){
                    //任何线程要修改hp的值，必须先占用someObject
                    synchronized (gareen) {
                        gareen.hurt();
                    }

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            };
            t.start();
            reduceThreads[i] = t;
        }

        for (Thread t : addThreads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        for (Thread t : reduceThreads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        System.out.printf("%d个增加线程和%d个减少线程结束后%n盖伦的血量是 %d%n", n,n,gareen.hp);
    }
}
