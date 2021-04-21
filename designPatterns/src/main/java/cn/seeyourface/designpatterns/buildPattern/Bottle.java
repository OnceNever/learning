package cn.seeyourface.designpatterns.buildPattern;

/**
 * @ClassName: Wrapper
 * @Description: TODO 瓶子
 * @Author: Yanglei
 * @Date: 2021/4/21 17:03
 * @Version: V1.0
 */
public class Bottle implements Packing{
    @Override
    public String pack() {
        return "Bottle";
    }
}
