package com.yanglei.thread;

/**
 * @ClassName: TestThread1
 * @Description: TODO 单线程
 * @Author: Yanglei
 * @Date: 2020/9/23 11:15
 * @Version: V1.0
 */
public class TestThread1 {
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

        //盖伦攻击提莫
        while(!teemo.isDead(teemo.getHp())){
            gareen.attack(teemo);
        }

        //赏金猎人攻击盲僧
        while(!leesin.isDead(leesin.getHp())){
            bh.attack(leesin);
        }
    }
}
