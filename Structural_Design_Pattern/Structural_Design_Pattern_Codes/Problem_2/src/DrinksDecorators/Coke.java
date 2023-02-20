package DrinksDecorators;

import DrinksDecorators.DrinksDecorator;
import Meal.Meal;

public class Coke extends DrinksDecorator {
    public Coke(Meal newm) {
        super(newm);
    }
    public String prepareFood() {
        return super.prepareFood()+" Coke";
    }
    public double price() {
        return super.price()+40.00;
    }
}
