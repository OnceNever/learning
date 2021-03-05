package cn.seeyourface.javaIO.fileObject;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: FindFile
 * @Description: TODO 寻找windows目录下最大和最小的两个文件
 * @Author: Yanglei
 * @Date: 2021/3/5 16:37
 * @Version: V1.0
 */
public class FindFile {
    public static void main(String[] args) {
        File file = new File("C:/Windows");
        File[] files = file.listFiles();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                File maxFile = files[0];
                for (File f : files) {
                    if (f.isDirectory())
                        continue;
                    if (f.length() > maxFile.length()){
                        maxFile = f;
                    }
                }
                System.out.println("最大的文件是："+maxFile.getAbsoluteFile()+",它的大小是："+maxFile.length()+"字节");
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                File minFile = files[0];
                for (File f : files) {
                    if (f.isDirectory())
                        continue;
                    if (f.length() < minFile.length() && f.length() != 0){
                        minFile = f;
                    }
                }
                System.out.println("最小的文件是："+minFile.getAbsoluteFile()+",它的大小是："+minFile.length()+"字节");
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
