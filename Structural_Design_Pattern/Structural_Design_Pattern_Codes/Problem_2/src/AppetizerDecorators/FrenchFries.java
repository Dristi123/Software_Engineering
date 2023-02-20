package AppetizerDecorators;

import AppetizerDecorators.AppetizerDecorator;
import Meal.Meal;

public class FrenchFries extends AppetizerDecorator {
    public FrenchFries(Meal newm) {
        super(newm);
    }
    public String prepareFood() {
        return super.prepareFood()+" French Fries";
    }
}
