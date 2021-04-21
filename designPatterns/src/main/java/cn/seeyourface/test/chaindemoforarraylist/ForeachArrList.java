package cn.seeyourface.test.chaindemoforarraylist;

import java.util.ArrayList;
import java.util.Date;

/**
 * @ClassName: ForiArrList
 * @Description: TODO
 * @Author: Yanglei
 * @Date: 2021/4/21 11:07
 * @Version: V1.0
 */
public class ForeachArrList extends AbstractArrList{
    @Override
    public void printTime(ArrayList<Integer> list) {
        long time1 = new Date().getTime();
        for (Integer i : list) {

        }
        long time2 = new Date().getTime();
        System.out.println("增强for循环花费时间：" + (time2 - time1));
    }
}
