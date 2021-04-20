package cn.seeyourface.designpatterns.factory.factorymethod;

/**
 * @ClassName: BreadFactory
 * @Description: TODO Step4：创建具体工厂角色
 * @Author: Yanglei
 * @Date: 2021/4/20 15:23
 * @Version: V1.0
 */
public class BreadFactory extends Factory{
    /**
    * @Description TODO 馒头工厂，只需要负责生产馒头
    * @Date 15:25 2021/4/20
    * @Param []
    * @return cn.seeyourface.designpatterns.factory.factorymethod.MachineApi
    **/
    @Override
    public MachineApi newMachine() {
        return new BreadMachine();
    }
}
