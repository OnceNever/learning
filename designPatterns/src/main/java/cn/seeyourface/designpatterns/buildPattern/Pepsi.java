package cn.seeyourface.designpatterns.buildPattern;

/**
 * @ClassName: Pepsi
 * @Description: TODO
 * @Author: Yanglei
 * @Date: 2021/4/21 17:17
 * @Version: V1.0
 */
public class Pepsi extends ColdDrinking{
    @Override
    public String name() {
        return "Pepsi";
    }

    @Override
    public float price() {
        return 12.0f;
    }
}
