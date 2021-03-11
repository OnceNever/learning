package com.yanglei.thread.mainMethod;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @ClassName: CyclicBarrier
 * @Description: TODO  多线程之回环栅栏 CyclicBarrier 的用法
 * @Author: Yanglei
 * @Date: 2021/3/11 14:23
 * @Version: V1.0
 */
public class CyclicBarrierTest {
    static int n = 5;
    static final CyclicBarrier barrier = new CyclicBarrier(5);

    public static void main(String[] args) {
        for (int i = 0; i < n; i++) {
            new BarrierThread(barrier).start();
        }
    }

    static class BarrierThread extends Thread{
        int i;
        CyclicBarrier barrier;
        public BarrierThread(CyclicBarrier barrier){
            this.barrier = barrier;
        }
        @Override
        public void run() {
            try {
                Thread.sleep((long)(5000*Math.random()));
                System.out.println("线程"+Thread.currentThread().getName()+"业务执行完毕，等待其他线程...");
                //线程执行到此的时候，进入到阻塞状态，并且等待其他线程都执行到此后，再统一放行，让它们同时向下继续执行
                // （放行后具体谁先执行，还是要看谁先抢到CPU执行权）
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("所有线程业务处理完毕...");
        }
    }
}
