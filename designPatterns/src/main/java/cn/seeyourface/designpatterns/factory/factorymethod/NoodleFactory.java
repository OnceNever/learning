package cn.seeyourface.designpatterns.factory.factorymethod;

/**
 * @ClassName: NoodleFactory
 * @Description: TODO Step4：创建具体工厂角色，面条工厂
 * @Author: Yanglei
 * @Date: 2021/4/20 15:27
 * @Version: V1.0
 */
public class NoodleFactory extends Factory{
    /**
    * @Description TODO 面条工厂只负责生产面条
    * @Date 15:28 2021/4/20
    * @Param []
    * @return cn.seeyourface.designpatterns.factory.factorymethod.MachineApi
    **/
    @Override
    public MachineApi newMachine() {
        return new NoodleMachine();
    }
}
