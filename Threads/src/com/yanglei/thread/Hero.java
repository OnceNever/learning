package com.yanglei.thread;

/**
 * @ClassName: com.yanglei.thread.Hero
 * @Description: TODO
 * @Author: Yanglei
 * @Date: 2020/9/23 10:45
 * @Version: V1.0
 */
public class Hero {
    public String name;
    public Integer hp;
    public Integer damage;

    public Integer getDamage() {
        return damage;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }

    public void attack(Hero hero){

//        try {
//            /*
//            * @Description TODO 模拟英雄攻击需要时间
//            * @Date 10:51 2020/9/23
//            * @Param [hero]
//            * @return void
//            **/
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        hero.hp -= damage;
        System.out.format("%s 正在攻击 %s ， %s 的血量变成了 %d%n",name, hero.name, hero.name, hero.hp);
        if(isDead(hero.hp)){
            System.out.println(hero.name+"死了！");
        }

    }

    //回血
    public synchronized void recover(){
        while(this.hp >= 5){
            try {
                //血量到达上限，等待扣血
                System.out.println("血量到达上限，等待扣血...");
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        hp=hp+1;
        System.out.println("英雄回血，当前血量为："+this.hp);
        this.notify();
    }

    //掉血
    public synchronized void hurt(){
        while(this.hp <= 1){
            try {
                System.out.println("英雄血量只剩1点，等待回血...");
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        hp=hp-1;
        System.out.println("英雄扣血，当前血量为："+this.hp);
        //掉血之后唤醒等待的线程
        this.notify();
    }

    public boolean isDead(Integer hp){
        return 0 >= hp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }
}
