package com.yanglei.thread;

/**
 * @ClassName: KillThread
 * @Description: TODO
 * @Author: Yanglei
 * @Date: 2020/9/23 11:24
 * @Version: V1.0
 */
public class KillThread implements Runnable{
    private Hero h1;
    private Hero h2;

    public KillThread(Hero h1, Hero h2){
        this.h1 = h1;
        this.h2 = h2;
    }

    @Override
    public void run() {
        while(!h2.isDead(h2.getHp())){
            h1.attack(h2);
        }
    }
}
