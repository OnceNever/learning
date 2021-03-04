package com.yanglei.thread;

/**
 * @ClassName: AHero
 * @Description: TODO
 * @Author: Yanglei
 * @Date: 2021/3/3 15:19
 * @Version: V1.0
 */
public class AHero {

    public void attack(int i){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("波动拳第"+ i +"拳");
    }
}
