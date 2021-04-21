package cn.seeyourface.designpatterns.buildPattern;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName: Meal
 * @Description: TODO 创建一个Meal类，带有定义的item对象
 * @Author: Yanglei
 * @Date: 2021/4/21 17:19
 * @Version: V1.0
 */
public class Meal {
    private List<Item> items = new ArrayList<Item>();
    float money = 0.0f;

    public void addItem(Item item){
        items.add(item);
    }

    public float getCost() {
        //float money = 0.0f;
        for (int i = 0; i < items.size(); i++) {
            money += items.get(i).price();
        }
        return money;
    }

    public void showItems() {
        for (Item item : items) {
            System.out.print("Item : "+item.name());
            System.out.print(", Packing : "+item.packing().pack());
            System.out.println(", Price : "+item.price());
        }
    }
}
