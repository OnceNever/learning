package cn.test;

/**
 * @ClassName: Userqaq
 * @Description: TODO  三种加载器
 * @Author: Yanglei
 * @Date: 2021/4/19 14:50
 * @Version: V1.0
 */
public class Userqaq {
    public static void main(String[] args) {
        ClassLoader classLoader = Userqaq.class.getClassLoader();
        System.out.println(classLoader);//系统类加载器 Application ClassLoader
        ClassLoader classLoader1 = Userqaq.class.getClassLoader().getParent();
        System.out.println(classLoader1);//扩展类加载器 Extension ClassLoader
        ClassLoader classLoader2 = Userqaq.class.getClassLoader().getParent().getParent();
        System.out.println(classLoader2);//启动类加载器 BootStrap ClassLoader 因为是C语言实现的所以无法获取到
    }
}
