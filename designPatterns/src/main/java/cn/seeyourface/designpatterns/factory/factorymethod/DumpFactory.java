package cn.seeyourface.designpatterns.factory.factorymethod;

/**
 * @ClassName: DumpFactory
 * @Description: TODO 扩展-饺子具体工厂角色
 * @Author: Yanglei
 * @Date: 2021/4/20 15:43
 * @Version: V1.0
 */
public class DumpFactory extends Factory{
    @Override
    public MachineApi newMachine() {
        return new DumpMachine();
    }
}
