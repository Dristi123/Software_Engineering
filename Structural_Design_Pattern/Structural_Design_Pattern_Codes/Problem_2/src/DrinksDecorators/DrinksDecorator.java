package DrinksDecorators;

import Meal.Meal;
import Meal.MealDecorator;

public class DrinksDecorator extends MealDecorator {
    public DrinksDecorator(Meal m) {
        newmeal=m;
    }
    public String prepareFood() {
        return newmeal.prepareFood();
    }
    public double price() {
        return newmeal.price();
    }
}
