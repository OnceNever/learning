package cn.seeyourface.javaIO.stream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @ClassName: TestStream2
 * @Description: TODO FileOutputStream
 * @Author: Yanglei
 * @Date: 2021/3/8 16:38
 * @Version: V1.0
 */
public class TestStream2 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = null;
        //准备一个空文件
        File file = new File("E:/IOTest/fileOutputStream.txt");
        //对应的字符是X,Y
        byte[] data = new byte[]{88, 89};
        try {
            fos = new FileOutputStream(file);
            //写入
            fos.write(data);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            fos.close();
        }
    }
}
