package cn.seeyourface.test.chaindemoforarraylist;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/**
 * @ClassName: ForiArrList
 * @Description: TODO
 * @Author: Yanglei
 * @Date: 2021/4/21 11:07
 * @Version: V1.0
 */
public class Foreach8ArrList extends AbstractArrList{
    @Override
    public void printTime(ArrayList<Integer> list) {
        long time1 = new Date().getTime();
        list.forEach(p -> {

        });
        long time2 = new Date().getTime();
        System.out.println("Java8新特性花费时间：" + (time2 - time1));
    }
}
