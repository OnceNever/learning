package cn.seeyourface.designpatterns.proxyPatterns;

/**
 * @ClassName: RealImage
 * @Description: TODO
 * @Author: Yanglei
 * @Date: 2021/4/25 18:10
 * @Version: V1.0
 */
public class RealImage implements Image{

    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    @Override
    public void display() {
        System.out.println("Display " + fileName);
    }

    private void loadFromDisk(String fileName) {
        System.out.println("Loading " + fileName);
    }
}
