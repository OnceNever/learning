package com.yanglei.thread.ProducerConsumer;

import java.util.Stack;

/**
 * @ClassName: SyncStack
 * @Description: TODO 重写Stack类中线程用到的两个方法，根据所需在特定条件下执行wait()和notify()
 * @Author: Yanglei
 * @Date: 2021/3/4 11:11
 * @Version: V1.0
 */
public class SyncStack extends Stack {
    @Override
    public synchronized Object push(Object item) {
        while(super.size() > 200){
            try {
                System.out.println("栈中元素超过200，等待消费线程消费...");
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notify();
        return super.push(item);
    }

    @Override
    public synchronized Object pop() {
        while(super.empty()){
            try {
                System.out.println("栈中暂无元素可消费，等待生产线程生产...");
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notify();
        return super.pop();
    }
}
