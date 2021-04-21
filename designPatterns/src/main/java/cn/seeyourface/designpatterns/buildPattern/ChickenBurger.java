package cn.seeyourface.designpatterns.buildPattern;

/**
 * @ClassName: ChickenBurger
 * @Description: TODO
 * @Author: Yanglei
 * @Date: 2021/4/21 17:13
 * @Version: V1.0
 */
public class ChickenBurger extends Burger{
    @Override
    public String name() {
        return "Chicken Burger";
    }

    @Override
    public float price() {
        return 30.0f;
    }
}
