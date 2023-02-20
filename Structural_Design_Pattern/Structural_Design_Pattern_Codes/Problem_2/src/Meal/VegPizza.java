package Meal;

import Meal.Pizza;

public class VegPizza extends Pizza {
    public  String prepareFood() {
        return "Veg Pizza";
    }
    public double price() {
        return  500.00;
    }
}
