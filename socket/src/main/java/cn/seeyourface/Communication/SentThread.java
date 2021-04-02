package cn.seeyourface.Communication;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @ClassName: SentThread
 * @Description: TODO 多线程聊天写线程
 * @Author: Yanglei
 * @Date: 2021/4/2 14:09
 * @Version: V1.0
 */
public class SentThread implements Runnable{
    Socket s;

    public SentThread(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        //创建输出字节流
        OutputStream os = null;
        //字节流包装类，便于发送字符串
        DataOutputStream dos = null;
        try {
            os = s.getOutputStream();
            dos = new DataOutputStream(os);
            while (true) {
                //获取待发送内容
                Scanner scanner = new Scanner(System.in);
                String msg = scanner.nextLine();
                dos.writeUTF(msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                dos.close();
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
