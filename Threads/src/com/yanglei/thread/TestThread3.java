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
        teemo.setDamage(30);

        Hero bh = new Hero();
        bh.setName("赏金");
        bh.setHp(500);
        bh.setDamage(65);

        Hero leesin = new Hero();
        leesin.setName("盲僧");
        leesin.setHp(455);
        leesin.setDamage(80);

        new Thread(){
            @Override
            public void run() {
                if(gareen.getHp() > 0){
                    while(!teemo.isDead(teemo.getHp())){
                        gareen.attack(teemo);
                    }
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                if(teemo.getHp() > 0){
                    while(!gareen.isDead(gareen.getHp())){
                        teemo.attack(gareen);
                    }
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                if(bh.getHp() > 0){
                    while(!leesin.isDead(leesin.getHp())){
                        bh.attack(leesin);
                    }
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                if(leesin.getHp() > 0){
                    while(!bh.isDead(bh.getHp())){
                        leesin.attack(bh);
                    }
                }
            }
        }.start();
    }
}
