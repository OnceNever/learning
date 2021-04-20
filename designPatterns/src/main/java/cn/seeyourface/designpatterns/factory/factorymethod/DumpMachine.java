package cn.seeyourface.designpatterns.factory.factorymethod;

/**
 * @ClassName: DumpMachine
 * @Description: TODO  工厂方法模式极大便利了扩展 比如需要新增一个制造饺子
 * @Author: Yanglei
 * @Date: 2021/4/20 15:41
 * @Version: V1.0
 */
public class DumpMachine implements MachineApi{
    @Override
    public void process(String material) {
        System.out.println("通过饺子机器将" + material + "加工成了饺子");
    }
}
