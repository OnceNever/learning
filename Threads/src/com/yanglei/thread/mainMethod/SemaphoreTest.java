package com.yanglei.thread.mainMethod;

import java.util.concurrent.Semaphore;

/**
 * @ClassName: SemaphoreTest
 * @Description: TODO 多线程之 信号量 Semaphore 可以控制同时访问的线程个数
 * 使用场景：若一个工厂有 5 台机器，但是有 8 个工人，一台机器同时只能被一个工人使用，只有使用完
 * 了，其他工人才能继续使用。
 * @Author: Yanglei
 * @Date: 2021/3/11 15:33
 * @Version: V1.0
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        int n = 8;//8个工人
        final Semaphore semaphore = new Semaphore(5);//5台机器

        for (int i = 0; i < n; i++) {
            new SemaphoreThread(i, semaphore).start();
        }
    }

    static class SemaphoreThread extends Thread{
        int n;
        Semaphore semaphore;
        public SemaphoreThread(int n, Semaphore semaphore){
            this.n = n;
            this.semaphore =semaphore;
        }

        @Override
        public void run() {
            try {
                //获取一个许可
                semaphore.acquire();
                System.out.println("工人"+n+"占领一台机器，正在工作...");
                Thread.sleep(6000);
                //释放许可的前提是必须拥有许可
                semaphore.release();
                System.out.println("工人"+n+"释放出机器...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
