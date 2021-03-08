package cn.seeyourface.ping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: PingTest
 * @Description: TODO
 * @Author: Yanglei
 * @Date: 2021/3/8 15:15
 * @Version: V1.0
 */
public class PingTest {
    public static void main(String[] args) throws Exception {
        //定义线程池 ping某个网段的IP地址是否可用
        ThreadPoolExecutor pool =
                new ThreadPoolExecutor(2, 5, 10, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        for (int i = 240; i <= 255; i++) {
            String ip = "10.73.242."+i;
            pool.execute(new PingThread(ip));
        }
    }
}
