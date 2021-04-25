package cn.seeyourface.designpatterns.proxyPatterns;

/**
 * @ClassName: ProxyPatternDemo
 * @Description: TODO
 * @Author: Yanglei
 * @Date: 2021/4/25 18:22
 * @Version: V1.0
 */
public class ProxyPatternDemo {

    public static void main(String[] args) {
        Image image = new ProxyImage("test_10mb.jpg");

        // 图像将从磁盘加载
        image.display();
        System.out.println("---------");
        // 图像不需要从磁盘加载
        image.display();
    }
}
