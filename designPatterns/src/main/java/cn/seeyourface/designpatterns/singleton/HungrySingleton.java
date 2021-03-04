package cn.seeyourface.designpatterns.singleton;

/**
 * @ClassName: HungrySingleton
 * @Description: TODO 单例模式，饿汉式。系统启动时初始化，线程安全，但可能会耗费额外的系统资源
 * @Author: Yanglei
 * @Date: 2021/3/2 11:08
 * @Version: V1.0
 */
public class HungrySingleton {
    //创建一个实例对象
    private static HungrySingleton instance = new HungrySingleton();

    //私有构造方法，防止被实例化
    private HungrySingleton(){};

    //提供一个公开的静态get()方法
    public static HungrySingleton getInstance(){
        return instance;
    }
}
