package cn.seeyourface.designpatterns.buildPattern;

/**
 * @ClassName: Burger
 * @Description: TODO 创建item接口的抽象类，提供默认功能，意思是汉堡默认用纸袋打包，后面还有什么鸡肉汉堡牛肉汉堡继承这个类
 *                    然后实现价格和名字的抽象方法。
 * @Author: Yanglei
 * @Date: 2021/4/21 17:05
 * @Version: V1.0
 */
public abstract class Burger implements Item{

    @Override
    public Packing packing() {
        return new Wrapper();
    }
}
