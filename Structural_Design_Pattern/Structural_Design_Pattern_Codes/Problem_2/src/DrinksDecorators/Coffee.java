package DrinksDecorators;

import DrinksDecorators.DrinksDecorator;
import Meal.Meal;

public class Coffee extends DrinksDecorator {
    public Coffee(Meal newm) {
        super(newm);
    }
    public String prepareFood() {
        return super.prepareFood()+" Coffee";
    }
    public double price() {
        return super.price()+60.00;
    }
}
