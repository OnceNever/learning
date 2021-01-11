package com.yanglei.thread;

/**
 * @ClassName: com.yanglei.thread.Hero
 * @Description: TODO
 * @Author: Yanglei
 * @Date: 2020/9/23 10:45
 * @Version: V1.0
 */
public class Hero {
    private String name;
    private Integer hp;
    private Integer damage;

    public Integer getDamage() {
        return damage;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }

    public void attack(Hero hero){

        try {
            /*
            * @Description TODO 模拟英雄攻击需要时间
            * @Date 10:51 2020/9/23
            * @Param [hero]
            * @return void
            **/
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        hero.hp -= damage;
        System.out.format("%s 正在攻击 %s ， %s 的血量变成了 %d%n",name, hero.name, hero.name, hero.hp);
        if(isDead(hero.hp)){
            System.out.println(hero.name+"死了！");
        }

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
