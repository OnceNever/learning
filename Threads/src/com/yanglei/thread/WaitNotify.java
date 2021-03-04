package com.yanglei.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: WaitNotify
 * @Description: TODO
 * @Author: Yanglei
 * @Date: 2021/3/3 17:46
 * @Version: V1.0
 */
public class WaitNotify {
    public static void main(String[] args) {
        Hero gareen = new Hero();
        gareen.setName("盖伦");
        gareen.setHp(5);
        gareen.setDamage(50);

        Thread[] hurtThreads = new Thread[5];
        Thread[] recoverThreads = new Thread[2];

        for(int i = 0; i < 5; i++){
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    while(true){
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        gareen.hurt();
                    }
                }
            });
            t.start();
            hurtThreads[i] = t;
        }

        for (int i = 0; i < 2; i++){
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    while(true){
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        gareen.recover();
                    }
                }
            });
            t.start();
            recoverThreads[i] = t;
        }

        for (Thread t : hurtThreads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (Thread t : recoverThreads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
