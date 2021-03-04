package com.yanglei.thread;

/**
 * @ClassName: ADoGan
 * @Description: TODO 小练习： 英雄有可以放一个技能叫做: 波动拳-a du gen。
 *                           每隔一秒钟，可以发一次，但是只能连续发3次。
 *                           发完3次之后，需要充能5秒钟，充满，再继续发。
 * @Author: Yanglei
 * @Date: 2021/3/3 15:18
 * @Version: V1.0
 */
public class ADoGan {
    public static void main(String[] args) {
        AThread aThread = new AThread(new AHero());
        Thread t1 = new Thread(aThread);
        t1.start();
    }
}
