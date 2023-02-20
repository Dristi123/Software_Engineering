package AppetizerDecorators;

import Meal.Meal;
import Meal.MealDecorator;

public class AppetizerDecorator extends MealDecorator {
    public AppetizerDecorator(Meal m) {
        newmeal=m;
    }
    public String prepareFood() {
        return newmeal.prepareFood();
    }
    public double price() {
        return newmeal.price()+100.00;
    }
}
