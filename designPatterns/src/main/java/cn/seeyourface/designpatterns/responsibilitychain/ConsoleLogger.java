package cn.seeyourface.designpatterns.responsibilitychain;

/**
 * @ClassName: InfoLogger
 * @Description: TODO
 * @Author: Yanglei
 * @Date: 2021/4/20 17:10
 * @Version: V1.0
 */
public class ConsoleLogger extends AbstractLogger{
    public ConsoleLogger(int level) {
        this.level = level;
    }

    @Override
    public void write(String message) {
        System.out.println("Standard console::logger: " + message);
    }
}
