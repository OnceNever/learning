package cn.seeyourface.serverclient;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName: Server
 * @Description: TODO 服务端
 * @Author: Yanglei
 * @Date: 2021/4/2 11:12
 * @Version: V1.0
 */
public class Server {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket accept = null;
        InputStream inputStream = null;
        DataInputStream dataInputStream = null;
        try {
            int port = 6666;
            serverSocket = new ServerSocket(port);
            System.out.println("正在监听端口号"+ port +"...");
            while (true) {
                accept = serverSocket.accept();
                //System.out.println("有连接过来" + accept);

                //打开输入流
                inputStream = accept.getInputStream();
                dataInputStream = new DataInputStream(inputStream);
                String str = dataInputStream.readUTF();
                System.out.println("获取到客户端传入信息：" + str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                dataInputStream.close();
                inputStream.close();
                accept.close();
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
