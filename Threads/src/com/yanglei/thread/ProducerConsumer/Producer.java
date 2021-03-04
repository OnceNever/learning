package com.yanglei.thread.ProducerConsumer;

import java.util.Random;
import java.util.Stack;

/**
 * @ClassName: Producer
 * @Description: TODO 生产者线程，随机生产一个大写字符。存入栈中
 * @Author: Yanglei
 * @Date: 2021/3/4 10:31
 * @Version: V1.0
 */
public class Producer implements Runnable{
    SyncStack stack;
    public Producer(SyncStack stack){
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
            Character ch = this.produce();
            stack.push(ch);
            System.out.println(Thread.currentThread().getName()+"压入:"+ch);
        }
    }

    public Character produce(){
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //产生一个0-26的随机数
        int ran = new Random().nextInt(26);
        return str.charAt(ran);
    }
}
