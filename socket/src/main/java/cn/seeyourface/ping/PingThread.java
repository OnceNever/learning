package cn.seeyourface.ping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * @ClassName: PingThread
 * @Description: TODO
 * @Author: Yanglei
 * @Date: 2021/3/8 17:09
 * @Version: V1.0
 */
public class PingThread implements Runnable{
    String ip;
    public PingThread(String ip){
        this.ip = ip;
    }
    @Override
    public void run() {
        BufferedReader br = null;
        try {
            Process p = Runtime.getRuntime().exec("ping " + ip);
            br = new BufferedReader(new InputStreamReader(p.getInputStream(), "GBK"));
            String line = null;
            while((line = br.readLine()) != null){
                if(line.length() != 0 && line.contains("TTL")){
                    System.out.println("ping IP:"+ip+" 响应成功！");
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
