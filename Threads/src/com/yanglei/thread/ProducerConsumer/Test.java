package com.yanglei.thread.ProducerConsumer;

import java.util.Collections;
import java.util.Stack;

/**
 * @ClassName: Test
 * @Description: TODO 测试生产消费者线程
 * @Author: Yanglei
 * @Date: 2021/3/4 11:03
 * @Version: V1.0
 */
public class Test {
    public static void main(String[] args) {
        SyncStack stack = new SyncStack();

        Producer producer1 = new Producer(stack);
        Producer producer2 = new Producer(stack);
        Consumer consumer1 = new Consumer(stack);
        Consumer consumer2 = new Consumer(stack);
        Consumer consumer3 = new Consumer(stack);
        Thread p1 = new Thread(producer1);
        Thread p2 = new Thread(producer2);
        Thread c1 = new Thread(consumer1);
        Thread c2 = new Thread(consumer2);
        Thread c3 = new Thread(consumer3);

        p1.setName("producer1");
        p2.setName("producer2");
        c1.setName("consumer1");
        c2.setName("consumer2");
        c3.setName("consumer3");
        p1.start();
        p2.start();
        c1.start();
        c2.start();
        c3.start();

    }
}
