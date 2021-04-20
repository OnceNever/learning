package cn.seeyourface.designpatterns.factory.factorymethod;

/**
 * @ClassName: Factory
 * @Description: TODO Step3：创建抽象工厂角色
 * @Author: Yanglei
 * @Date: 2021/4/20 15:16
 * @Version: V1.0
 */
public abstract class Factory {

    /**
    * @Description TODO 让子类（具体工厂）来实例化具体对象（机器）
    * @Date 15:18 2021/4/20
    * @Param []
    * @return cn.seeyourface.designpatterns.factory.factorymethod.MachineApi
    **/
    public abstract MachineApi newMachine();

    /**
    * @Description TODO 加工
    * @Date 15:21 2021/4/20
    * @Param [material]
    * @return void
    **/
    public void process(String material) {
        MachineApi machine = newMachine();
        machine.process(material);
    }
}
