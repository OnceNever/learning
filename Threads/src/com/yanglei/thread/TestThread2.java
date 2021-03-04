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
        Thread t1 = new Thread(thread1);
        t1.start();
        try {
            //将t1线程加入到主线程之中，等待t1线程运行结束之后主线程才会继续往下执行启动t2线程
            //这个方法使交替执行的两个进程变为有序执行，即先执行t1在执行t2
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        KillThread thread2 = new KillThread(bh, leesin);
        Thread t2 = new Thread(thread2);
        t2.start();
    }
}
