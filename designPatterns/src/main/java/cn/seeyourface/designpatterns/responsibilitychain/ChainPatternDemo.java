package cn.seeyourface.designpatterns.responsibilitychain;

/**
 * @ClassName: ChainPatternDemo
 * @Description: TODO   创建不同类型的记录器。赋予它们不同的错误级别，并在每个记录器中设置下一个记录器。
 *                      每个记录器中的下一个记录器代表的是链的一部分。
 * @Author: Yanglei
 * @Date: 2021/4/20 17:15
 * @Version: V1.0
 */
public class ChainPatternDemo {

    public static AbstractLogger getChainOfLoggers() {
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);
        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);

        errorLogger.setNext(fileLogger);
        fileLogger.setNext(consoleLogger);

        return errorLogger;
    }

    public static void main(String[] args) {
        AbstractLogger chainOfLoggers = ChainPatternDemo.getChainOfLoggers();

//        chainOfLoggers.logMessage(AbstractLogger.INFO, "This is an information");
        chainOfLoggers.logMessage(AbstractLogger.DEBUG, "This is a Debug information");
//        chainOfLoggers.logMessage(AbstractLogger.ERROR, "This is an Error information");
    }
}
