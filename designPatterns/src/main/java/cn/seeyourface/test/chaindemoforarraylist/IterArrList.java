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
public class IterArrList extends AbstractArrList{
    @Override
    public void printTime(ArrayList<Integer> list) {
        long time1 = new Date().getTime();
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) iterator.next();
        long time2 = new Date().getTime();
        System.out.println("迭代器花费时间：" + (time2 - time1));
    }
}
