package cn.seeyourface.designpatterns.buildPattern;

/**
 * @ClassName: BuildPatternDemo
 * @Description: TODO
 * @Author: Yanglei
 * @Date: 2021/4/21 17:35
 * @Version: V1.0
 */
public class BuildPatternDemo {

    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();

        Meal meal1 = mealBuilder.prepareChickMeal();
        System.out.println("Chick Meal:");
        meal1.showItems();
        System.out.println("Total Cost:" + meal1.getCost());

        System.out.println("=====================");

        Meal meal2 = mealBuilder.prepareVegMeal();
        System.out.println("Veg Meal:");
        meal2.showItems();
        System.out.println("Total Cost:" + meal2.getCost());

    }
}
