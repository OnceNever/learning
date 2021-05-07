package cn.seeyourface.test;

/**
 * @ClassName: JvmTest
 * @Description: TODO
 * @Author: Yanglei
 * @Date: 2021/5/7 17:11
 * @Version: V1.0
 */
public class JvmTest {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        testAllocation();
    }

    /**
    * -XX:+PrintGCDetails -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8
    **/
    public static void testAllocation(){
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];
    }
}
