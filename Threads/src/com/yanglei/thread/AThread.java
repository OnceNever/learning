package com.yanglei.thread;

/**
 * @ClassName: AThread
 * @Description: TODO
 * @Author: Yanglei
 * @Date: 2021/3/3 15:30
 * @Version: V1.0
 */
public class AThread implements Runnable{
    AHero hero;
    public AThread(AHero hero){
       this.hero = hero;
    }

    @Override
    public void run() {
        int i = 1;
        while(true){
            hero.attack(i);
            i++;
            if (i > 3){
                i = 1;
                System.out.println("开始为时五秒的充能...");
                try {
                    Thread.sleep(5000);
                    System.out.println("你的能量超乎你的想象，开始打拳！");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
