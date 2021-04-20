package cn.seeyourface.designpatterns.factory.factorymethod;

/**
 * @ClassName: BreadMachine
 * @Description: TODO Step2：创建具体产品角色，馒头机器
 * @Author: Yanglei
 * @Date: 2021/4/20 15:01
 * @Version: V1.0
 */
public class BreadMachine implements MachineApi {
    @Override
    public void process(String material) {
        System.out.println("通过馒头机器将" + material + "加工成了馒头");
    }
}
