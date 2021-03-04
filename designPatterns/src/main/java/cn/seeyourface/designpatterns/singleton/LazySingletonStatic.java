package cn.seeyourface.designpatterns.singleton;

/**
 * @ClassName: LazySingletonStatic
 * @Description: TODO 以静态内部类的方式构建懒汉式单例
 * @Author: Yanglei
 * @Date: 2021/3/2 11:40
 * @Version: V1.0
 */
public class LazySingletonStatic {
    private LazySingletonStatic(){};

    //使用一个静态内部类来维护单例
    public static class SingletonFactory{
        private static LazySingletonStatic instance = new LazySingletonStatic();
    }

    //获取实例
    public static LazySingletonStatic getInstance(){
        return SingletonFactory.instance;
    }

    //如果该对象被用于序列化，可以保证在序列化前后保持一致
    public Object readResolve(){
        return getInstance();
    }

    /**
     * TODO 该方法类似于饿汉式，但是又可以保证延迟加载 因为初始化LazySingletonStatic类时静态内部类不会加载，只有调用getInstance()方法时才会开始加载静态内部类。
     * 1.JVM可以保证一个类在加载的过程是互斥的，这样当我们第一次调用 getInstance() 的时候可以保证只会创建一个实例
     * 2.并且能够保证赋值给instance的内存初始化完毕
     * 3.而且该方法只会在第一次调用的时候使用互斥机制(因为第1点)，解决了低性能问题
    **/
}
