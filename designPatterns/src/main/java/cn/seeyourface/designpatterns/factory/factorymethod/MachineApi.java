package cn.seeyourface.designpatterns.factory.factorymethod;

/**
 * @ClassName: MachineApi
 * @Description: TODO Step1.创建抽象产品角色：无论是做馒头还是挂面，都有一个加工的方法，将它抽取出来
 * @Author: Yanglei
 * @Date: 2021/4/20 14:57
 * @Version: V1.0
 */
public interface MachineApi {
    /**
    * @Description TODO 加工方法
    * @Date 14:59 2021/4/20
    * @Param [material] 材料
    * @return void
    **/
    public void process(String material);
}
