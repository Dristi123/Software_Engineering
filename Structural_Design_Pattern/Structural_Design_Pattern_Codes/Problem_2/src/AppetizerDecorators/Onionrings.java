package AppetizerDecorators;

import AppetizerDecorators.AppetizerDecorator;
import Meal.Meal;

public class Onionrings extends AppetizerDecorator {
    public Onionrings(Meal newm) {
        super(newm);
    }
    public String prepareFood() {
        return super.prepareFood()+" Onion Rings";
    }
}
