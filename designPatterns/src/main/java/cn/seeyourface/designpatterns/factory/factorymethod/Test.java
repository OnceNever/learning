package cn.seeyourface.designpatterns.factory.factorymethod;

/**
 * @ClassName: Test
 * @Description: TODO 测试类
 * @Author: Yanglei
 * @Date: 2021/4/20 15:30
 * @Version: V1.0
 */
public class Test {
    public static void main(String[] args) {
        BreadFactory breadFactory = new BreadFactory();
        breadFactory.process("面粉");

        DumpMachine dumpMachine = new DumpMachine();
        dumpMachine.process("面粉");
    }
}
