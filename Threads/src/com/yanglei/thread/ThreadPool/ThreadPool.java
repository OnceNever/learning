package com.yanglei.thread.ThreadPool;

import java.util.LinkedList;

/**
 * @ClassName: ThreadPool
 * @Description: TODO 自定义线程池
 * @Author: Yanglei
 * @Date: 2021/3/4 14:18
 * @Version: V1.0
 */
public class ThreadPool {
    //线程池大小
    int threadPoolSize;

    //任务容器
    LinkedList<Runnable> tasks = new LinkedList<>();

    //试图消费任务的线程
    public ThreadPool(){
        threadPoolSize = 10;
        synchronized (tasks){
            for (int i = 0; i < threadPoolSize; i++) {
                new TaskConsumeThread("任务消费者线程 "+i).start();
            }
        }
    }

    public void add(Runnable r){
        synchronized (tasks){
            //将任务添加到容器中
            tasks.add(r);
            //唤醒等待的任务消费者线程
            tasks.notifyAll();
        }
    }

    class TaskConsumeThread extends Thread{
        public TaskConsumeThread(String name){
            super(name);
        }

        Runnable task;

        public void run() {
            System.out.println("启动："+this.getName());
            while(true){
                synchronized (tasks){
                    while(tasks.isEmpty()){
                        try {
                            System.out.println("队列中暂无任务，线程等待中...");
                            tasks.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    task = tasks.removeLast();
                    //允许添加任务的线程可以继续添加任务
                    tasks.notifyAll();
                    System.out.println(this.getName()+"获取到任务，并执行");
                    task.run();
                }
            }
        }
    }
}
