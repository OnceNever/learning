package cn.seeyourface.javaIO.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @ClassName: TestStream
 * @Description: TODO FileInputStream
 * @Author: Yanglei
 * @Date: 2021/3/8 16:14
 * @Version: V1.0
 */
public class TestStream {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = null;
        try {
            File file = new File("E:/IOTest/streamTest.txt");
            //创建基于文件的输入流
            fis = new FileInputStream(file);
            //通过这个输入流，可以把数据从硬盘，读取到Java虚拟机中，也就是读取到内存中
            byte[] all = new byte[(int)file.length()];
            fis.read(all);
            for (byte b : all) {
                System.out.println(b);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            //每次使用完流都要关闭
            fis.close();
        }

    }
}
