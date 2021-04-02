package cn.seeyourface.Communication;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName: Client
 * @Description: TODO
 * @Author: Yanglei
 * @Date: 2021/4/2 14:11
 * @Version: V1.0
 */
public class Server {
    private static int PORT = 9527;

    public static void main(String[] args) {
        ServerSocket ss = null;
        Socket socket;
        try {
            ss = new ServerSocket(PORT);
            socket = ss.accept();

            WriteThread writeThread = new WriteThread(socket);
            SentThread readThread = new SentThread(socket);

            new Thread(writeThread).start();
            new Thread(readThread).start();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                ss.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
