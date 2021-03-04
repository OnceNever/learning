package cn.seeyourface.designpatterns.singleton;

/**
 * @ClassName: LazySingletonPro
 * @Description: TODO 双检索做两次判断，优化懒汉式单例模式处理速度
 * @Author: Yanglei
 * @Date: 2021/3/2 11:25
 * @Version: V1.0
 */
public class LazySingletonPro {
    //volatile关键字的作用是防止指令重排，因为 instance = new LazySingletonPro() 不是一个原子操作，在jvm中分为两步操作
    //1.为instance在堆中分配内存空间 2.初始化
    private volatile static LazySingletonPro instance;
    private LazySingletonPro(){};
    public static LazySingletonPro getInstance(){
        //实例为空进入同步代码块
        if (null == instance){
            synchronized (LazySingletonPro.class){
                //再次检查实例是否存在，不存在则创建实例
                if (null == instance){
                    instance = new LazySingletonPro();
                }
            }
        }
        return instance;
    }

    /**
     * TODO 如果不加volatile关键字可能会出现的错误举例
     * A、B线程同时进入了第一个if判断
     *
     * A首先进入synchronized块，由于instance为null，所以它执行instance = new Singleton();
     *
     * 由于JVM内部的优化机制，JVM先画出了一些分配给Singleton实例的空白内存，并赋值给instance成员（注意此时JVM没有开始初始化这个实例），然后A离开了synchronized块。
     *
     * B进入synchronized块，由于instance此时不是null，因此它马上离开了synchronized块并将结果返回给调用该方法的程序。
     *
     * 此时B线程打算使用Singleton实例，却发现它没有被初始化，于是错误发生了。
    **/
}
