package Meal;

import Meal.Pizza;

public class BeefPizza extends Pizza {
    public  String prepareFood() {
        return "Beef Pizza";
    }
    public double price() {
        return  700.00;
    }
}
