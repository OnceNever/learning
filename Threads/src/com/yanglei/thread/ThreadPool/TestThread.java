package com.yanglei.thread.ThreadPool;

/**
 * @ClassName: TestThread
 * @Description: TODO 测试自定义线程池执行任务
 * @Author: Yanglei
 * @Date: 2021/3/4 14:37
 * @Version: V1.0
 */
public class TestThread {
    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool();
        int sleep = 1000;
        while(true) {
            Runnable task = new Runnable(){
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("do something...");
                }
            };
            threadPool.add(task);
            try {
                Thread.sleep(sleep);
                sleep = sleep > 100 ? sleep -100 : sleep;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
