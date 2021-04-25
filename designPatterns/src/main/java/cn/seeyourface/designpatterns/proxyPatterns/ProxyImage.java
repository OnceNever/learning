package cn.seeyourface.designpatterns.proxyPatterns;

/**
 * @ClassName: ProxyImage
 * @Description: TODO
 * @Author: Yanglei
 * @Date: 2021/4/25 18:16
 * @Version: V1.0
 */
public class ProxyImage implements Image{

    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (null == realImage) {
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}
