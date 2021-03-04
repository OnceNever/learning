package com.yanglei.thread.ProducerConsumer;

import java.util.Stack;

/**
 * @ClassName: Consumer
 * @Description: TODO 消费者线程,打印栈中的字符
 * @Author: Yanglei
 * @Date: 2021/3/4 10:51
 * @Version: V1.0
 */
public class Consumer implements Runnable{
    SyncStack stack;
    public Consumer(SyncStack stack){
        this.stack = stack;
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //打印并删除栈顶的元素
            System.out.println(Thread.currentThread().getName()+"弹出:"+stack.pop());
        }
    }
}
