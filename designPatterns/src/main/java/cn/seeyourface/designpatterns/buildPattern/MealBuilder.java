package cn.seeyourface.designpatterns.buildPattern;

/**
 * @ClassName: MealBuilder
 * @Description: TODO  将食物组装成套餐
 * @Author: Yanglei
 * @Date: 2021/4/21 17:30
 * @Version: V1.0
 */
public class MealBuilder {

    public Meal prepareVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }

    public Meal prepareChickMeal() {
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        return meal;
    }
}
