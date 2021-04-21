package cn.seeyourface.test.chaindemoforarraylist;

import java.util.ArrayList;

/**
 * @ClassName: AbstractArrList
 * @Description: TODO 使用责任链模式测试ArrayList四种遍历方式的效率
 * @Author: Yanglei
 * @Date: 2021/4/21 10:59
 * @Version: V1.0
 */
public abstract class AbstractArrList {

    protected AbstractArrList next;

    public void setNextList(AbstractArrList abstractArrList) {
        this.next = abstractArrList;
    }

    public abstract void printTime(ArrayList<Integer> list);

    public void start(ArrayList<Integer> list) {
        printTime(list);
        if (next != null) {
            next.start(list);
        }
    }
}
