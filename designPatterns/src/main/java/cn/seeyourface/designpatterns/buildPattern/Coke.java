package cn.seeyourface.designpatterns.buildPattern;

/**
 * @ClassName: Coke
 * @Description: TODO
 * @Author: Yanglei
 * @Date: 2021/4/21 17:15
 * @Version: V1.0
 */
public class Coke extends ColdDrinking{
    @Override
    public String name() {
        return "Coke";
    }

    @Override
    public float price() {
        return 12.0f;
    }
}
