package cn.seeyourface.test.chaindemoforarraylist;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Demo
 * @Description: TODO
 * @Author: Yanglei
 * @Date: 2021/4/21 13:48
 * @Version: V1.0
 */
public class Demo {

    public static AbstractArrList getList(){
        AbstractArrList foriList = new ForiArrList();
        AbstractArrList foreachList = new ForeachArrList();
        AbstractArrList foreach8List = new Foreach8ArrList();
        AbstractArrList iterArrList = new IterArrList();

        foriList.setNextList(foreachList);
        foreachList.setNextList(foreach8List);
        foreach8List.setNextList(iterArrList);

        return foriList;
    }

    public static void main(String[] args) {
        AbstractArrList list = Demo.getList();
        ArrayList<Integer> arrlist = new ArrayList<Integer>();
        for (int i = 0; i < 50000; i++) {
            arrlist.add(i);
        }
        list.start(arrlist);
    }
}
