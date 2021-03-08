package cn.seeyourface.ip;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @ClassName: IpTest
 * @Description: TODO
 * @Author: Yanglei
 * @Date: 2021/3/8 15:08
 * @Version: V1.0
 */
public class IpTest {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress host = InetAddress.getLocalHost();
        String hostAddress = host.getHostAddress();
        System.out.println("本机IP地址是："+hostAddress);
    }
}
