package com.yanglei.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @ClassName: PasswordCrack
 * @Description: TODO   1. 生成一个长度是3的随机字符串，把这个字符串当作 密码
 *                      2. 创建一个破解线程，使用穷举法，匹配这个密码
 *                      3. 创建一个日志线程，打印都用过哪些字符串去匹配，这个日志线程设计为守护线程
 * @Author: Yanglei
 * @Date: 2021/3/3 15:46
 * @Version: V1.0
 */
public class PasswordCrack {
    public static void main(String[] args) {
        //生成三位数随机密码
        String password = getRandomString(3);
        System.out.println("待破解密码为："+password);

        //新建一个容器存储密码
        List<String> pwdList = new ArrayList<String>();

        //创建一个破解线程
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
                outer:for(int i = 0; i < 62; i++){
                    for (int j = 0; j < 62; j++){
                        for(int k = 0; k < 62; k++){
                            String pwd = String.valueOf(str.charAt(i)) + String.valueOf(str.charAt(j)) + String.valueOf(str.charAt(k));
                            pwdList.add(pwd);
                            if(pwd.equals(password)){
                                break outer;
                            }
                        }
                    }
                }
            }
        });

        //创建一个守护线程，打印穷举过的密码
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                int num = 1;
                boolean flag = true;
                while(flag){
                    if(pwdList == null || pwdList.size() == 0){
                        try {
                            System.out.println("等待匹配中...");
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        for(int i = 0; i < pwdList.size(); i++){
                            System.out.println("正在尝试第"+num+"个密码："+pwdList.get(i));
                            if(pwdList.get(i).equals(password)){
                                System.out.println("密码匹配成功！正确密码为："+pwdList.get(i));
                                flag = false;
                            }
                            num++;
                        }
                        pwdList.clear();
                    }
                }
            }
        });

        t1.start();
        t2.start();
    }

    //随机生成一个指定长度的字符串
    public static String getRandomString(int length){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}
