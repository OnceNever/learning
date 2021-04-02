package cn.seeyourface.Communication;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * @ClassName: ResponseThread
 * @Description: TODO 多线程聊天读线程
 * @Author: Yanglei
 * @Date: 2021/4/2 14:10
 * @Version: V1.0
 */
public class WriteThread implements Runnable{
    Socket s;

    public WriteThread(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        InputStream io = null;
        DataInputStream dis = null;
        try {
            io = s.getInputStream();
            dis = new DataInputStream(io);
            while (true) {
                String msg = dis.readUTF();
                System.out.println(msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                dis.close();
                io.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
