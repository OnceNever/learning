package cn.seeyourface.designpatterns.factory.factorymethod;

/**
 * @ClassName: NoodleMachine
 * @Description: TODO Step2：创建具体产品角色，面条机器
 * @Author: Yanglei
 * @Date: 2021/4/20 15:05
 * @Version: V1.0
 */
public class NoodleMachine implements MachineApi{
    @Override
    public void process(String material) {
        System.out.println("通过面条机器将" + material + "加工成了面条");
    }
}
