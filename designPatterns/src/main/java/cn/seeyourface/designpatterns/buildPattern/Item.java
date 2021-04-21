package cn.seeyourface.designpatterns.buildPattern;

/**
 * @ClassName: Item
 * @Description: TODO 创建一个表示食物信息和食物包装的接口
 * @Author: Yanglei
 * @Date: 2021/4/21 16:59
 * @Version: V1.0
 */
public interface Item {
    public String name();
    public float price();
    public Packing packing();
}
