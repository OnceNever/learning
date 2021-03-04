package cn.seeyourface.designpatterns.singleton;

/**
 * @ClassName: LazySingletonPlus
 * @Description: TODO 懒汉式升级版，解决多线程系统的不安全问题
 * @Author: Yanglei
 * @Date: 2021/3/2 11:19
 * @Version: V1.0
 */
public class LazySingletonPlus {
    private static LazySingletonPlus instance;

    private LazySingletonPlus(){};

    //增加synchronized关键字
    public static synchronized LazySingletonPlus getInstance(){
        if (null == instance){
            instance = new LazySingletonPlus();
        }
        return instance;
    }

    /*
    * 这样做虽然能解决多线程系统中的线程安全问题，但是是以时间换取空间的代价严重降低了系统的处理速度，还可以在升级。
    **/
}
