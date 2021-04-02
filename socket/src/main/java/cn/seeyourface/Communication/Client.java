package cn.seeyourface.Communication;

import java.io.IOException;
import java.net.Socket;

/**
 * @ClassName: Server
 * @Description: TODO
 * @Author: Yanglei
 * @Date: 2021/4/2 14:11
 * @Version: V1.0
 */
public class Client {
    private static int PORT = 9527;

    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1", PORT);

            WriteThread writeThread = new WriteThread(socket);
            SentThread readThread = new SentThread(socket);

            new Thread(writeThread).start();
            new Thread(readThread).start();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }
}
