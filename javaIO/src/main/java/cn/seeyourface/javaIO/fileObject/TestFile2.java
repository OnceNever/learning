package cn.seeyourface.javaIO.fileObject;

import java.io.File;
import java.io.IOException;

/**
 * @ClassName: TestFile2
 * @Description: TODO 文件常用操作
 * @Author: Yanglei
 * @Date: 2021/3/5 16:16
 * @Version: V1.0
 */
public class TestFile2 {
    public static void main(String[] args) throws IOException {
        File f = new File("E:/IOTest/fileTest");
        System.out.println("判断是否存在："+f.exists());
        //以数组形式返回当前文件夹下的所有文件(不包含子文件以及子文件夹)
        File[] files = f.listFiles();
        for (File file : files) {
            System.out.println("file-"+file);
        }
        // 以字符串形式返回获取所在文件夹
        System.out.println("所在文件夹"+f.getParent());

        // 以文件形式返回获取所在文件夹
        f.getParentFile();
        // 创建文件夹，如果父文件夹IOTest不存在，创建就无效
        f.mkdir();

        // 创建文件夹，如果父文件夹IOTest不存在，就会创建父文件夹
        f.mkdirs();

        // 创建一个空文件,如果父文件夹IOTest不存在，就会抛出异常
        f.createNewFile();
        // 所以创建一个空文件之前，通常都会创建父目录
        f.getParentFile().mkdirs();

        // 列出所有的盘符c: d: e: 等等
        f.listRoots();

        // 刪除文件
        f.delete();

        // JVM结束的时候，刪除文件，常用于临时文件的删除
        f.deleteOnExit();
    }
}
