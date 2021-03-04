package com.yanglei.thread;

/**
 * @ClassName: TestThread3
 * @Description: TODO 多线程测试 匿名内部类
 * @Author: Yanglei
 * @Date: 2020/9/23 11:36
 * @Version: V1.0
 */
public class TestThread3 {
    public static void main(String[] args) {
        Hero gareen = new Hero();
        gareen.setName("盖伦");
        gareen.setHp(616);
        gareen.setDamage(50);

        Hero teemo = new Hero();
        teemo.setName("提莫");
        teemo.setHp(300);
        teemo.setDamage(60);

        Hero bh = new Hero();
        bh.setName("赏金");
        bh.setHp(500);
        bh.setDamage(65);

        Hero leesin = new Hero();
        leesin.setName("盲僧");
        leesin.setHp(455);
        leesin.setDamage(80);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(!gareen.isDead(gareen.getHp()) && !teemo.isDead(teemo.getHp())){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    gareen.attack(teemo);
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(!teemo.isDead(teemo.getHp()) && !gareen.isDead(gareen.getHp())){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    teemo.attack(gareen);
                }
            }
        }).start();

        /*new Thread(new Runnable() {
            @Override
            public void run() {
                while(!bh.isDead(bh.getHp()) && !leesin.isDead(leesin.getHp())){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    bh.attack(leesin);
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(!leesin.isDead(leesin.getHp()) && !bh.isDead(bh.getHp())){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    leesin.attack(bh);
                }
            }
        }).start();*/
    }
}
