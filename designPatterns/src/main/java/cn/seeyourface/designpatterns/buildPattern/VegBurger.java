package cn.seeyourface.designpatterns.buildPattern;

/**
 * @ClassName: VegBurger
 * @Description: TODO 扩展Burger和ColdDrinking的实体类
 * @Author: Yanglei
 * @Date: 2021/4/21 17:09
 * @Version: V1.0
 */
public class VegBurger extends Burger{
    @Override
    public String name() {
        return "Veg Burger";
    }

    @Override
    public float price() {
        return 38.0f;
    }
}
