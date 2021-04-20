package cn.seeyourface.designpatterns.responsibilitychain;

/**
 * @ClassName: AbstractLogger
 * @Description: TODO  1.创建抽象的记录器类
 * @Author: Yanglei
 * @Date: 2021/4/20 17:00
 * @Version: V1.0
 */
public abstract class AbstractLogger {
    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;

    protected int level;

    //责任链中的下一个元素
    protected AbstractLogger next;

    public void setNext(AbstractLogger abstractLogger) {
        this.next = abstractLogger;
    }

    public abstract void write(String message);

    public void logMessage(int level, String message) {
        if (this.level <= level) {
            write(message);
        }
        if (next != null) {
            next.logMessage(level, message);
        }
    }
}
