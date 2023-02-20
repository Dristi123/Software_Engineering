package Meal;

import Meal.Meal;

public abstract class MealDecorator implements Meal {
    protected Meal newmeal;
    public abstract String prepareFood();
    public abstract double price();
}
