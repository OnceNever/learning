package com.yanglei.thread;

/**
 * @ClassName: ThreadPriority
 * @Description: TODO 1.测试线程优先级 便于观察需要注释线程暂停时间 2.测试yield()方法，当前线程暂停，其他线程有更多的机会占用cpu资源
 * @Author: Yanglei
 * @Date: 2021/3/3 14:54
 * @Version: V1.0
 */
public class ThreadPriority {
    public static void main(String[] args) {
        Hero gareen = new Hero();
        gareen.setName("盖伦");
        gareen.setHp(5000);
        gareen.setDamage(1);

        Hero teemo = new Hero();
        teemo.setName("提莫");
        teemo.setHp(5000);
        teemo.setDamage(1);

        Hero bh = new Hero();
        bh.setName("赏金");
        bh.setHp(5000);
        bh.setDamage(1);

        Hero leesin = new Hero();
        leesin.setName("盲僧");
        leesin.setHp(5000);
        leesin.setDamage(1);

        //1.线程优先级
        /*KillThread thread1 = new KillThread(gareen, teemo);
        Thread t1 = new Thread(thread1);
        KillThread thread2 = new KillThread(bh, leesin);
        Thread t2 = new Thread(thread2);
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t2.start();*/

        //2.yield() 线程暂停方法
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(!teemo.isDead(teemo.getHp())){
                    gareen.attack(teemo);
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(!leesin.isDead(leesin.getHp())){
                    //线程临时暂停
                    Thread.yield();
                    bh.attack(leesin);
                }
            }
        });
        t1.setPriority(Thread.NORM_PRIORITY);
        t2.setPriority(Thread.NORM_PRIORITY);
        t1.start();
        t2.start();
    }
}
