package cn.seeyourface.designpatterns.buildPattern;

/**
 * @ClassName: Wrapper
 * @Description: TODO 纸袋
 * @Author: Yanglei
 * @Date: 2021/4/21 17:03
 * @Version: V1.0
 */
public class Wrapper implements Packing{
    @Override
    public String pack() {
        return "Wrapper";
    }
}
