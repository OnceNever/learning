package cn.seeyourface.serverclient;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @ClassName: Client
 * @Description: TODO 客户端
 * @Author: Yanglei
 * @Date: 2021/4/2 11:19
 * @Version: V1.0
 */
public class Client {
    public static void main(String[] args) {
        String ip = "127.0.0.1";
        int port = 6666;
        Socket socket = null;
        OutputStream outputStream = null;
        //使用数据流封装字节流，便于传输字符串
        DataOutputStream dataOutputStream = null;
        try {
            while (true) {
                //连接到本机的ip端口
                socket = new Socket(ip, port);
                outputStream = socket.getOutputStream();
                dataOutputStream = new DataOutputStream(outputStream);

                Scanner scanner = new Scanner(System.in);
                String msg = scanner.nextLine();
                dataOutputStream.writeUTF(msg);
                System.out.println("向服务端发送消息：" + msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                dataOutputStream.close();
                outputStream.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
