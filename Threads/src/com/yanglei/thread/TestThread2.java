package com.yanglei.thread;

/**
 * @ClassName: TestThread2
 * @Description: TODO 多线程测试，实现Runable
 * @Author: Yanglei
 * @Date: 2020/9/23 11:28
 * @Version: V1.0
 */
public class TestThread2 {
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

        KillThread thread1 = new KillThread(gareen, teemo);
        new Thread(thread1).start();
        KillThread thread2 = new KillThread(bh, leesin);
        new Thread(thread2).start();
    }
}
