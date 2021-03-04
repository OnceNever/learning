package cn.seeyourface.designpatterns.singleton;

/**
 * @ClassName: LazySingleton
 * @Description: TODO 懒汉式。这种线程不安全。后续将一步步升级。
 * @Author: Yanglei
 * @Date: 2021/3/2 11:14
 * @Version: V1.0
 */
public class LazySingleton {
    //定义一个空的对象，使用时再去初始化。
    private static LazySingleton instance;

    //私有化构造器，防止被实例化
    private LazySingleton(){};

    //调用的时候才去初始化，但在多线程系统中是不安全的，可能会创建出多个实例
    public static LazySingleton getInstance(){
        if(null == instance){
            instance = new LazySingleton();
        }
        return instance;
    }
}
