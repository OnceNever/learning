package cn.seeyourface.javaIO.fileObject;

import java.io.File;
import java.util.Date;

/**
 * @ClassName: TestFile
 * @Description: TODO 文件常用方法
 * @Author: Yanglei
 * @Date: 2021/3/5 15:34
 * @Version: V1.0
 */
public class TestFile {
    public static void main(String[] args) {
        File file = new File("E:/IOTest/io.txt");
        System.out.println("当前文件是："+file);
        System.out.println("判断是否存在："+file.exists());
        System.out.println("判断是否问文件夹："+file.isDirectory());
        System.out.println("判断是否为文件(非文件夹)："+file.isFile());
        System.out.println("文件长度："+file.length());
        //文件最后修改时间
        long time = file.lastModified();
        Date t = new Date(time);
        System.out.println("文件最后修改时间是："+t);
        //设置文件修改时间为1970.1.1 08:00:00
        file.setLastModified(0);
        File file2 = new File("E:/IOTest/javaIO.txt");
        //文件重命名
        file.renameTo(file2);
        System.out.println("把文件名io.txt 修改为 javaIO.txt");
        System.out.println("注意： 需要在E:\\IOTest确实存在一个io.txt,才可以看到对应的文件长度、修改时间等信息");
    }
}
