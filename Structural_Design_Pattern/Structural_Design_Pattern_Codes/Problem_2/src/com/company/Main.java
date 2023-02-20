package com.company;

import AppetizerDecorators.FrenchFries;
import AppetizerDecorators.Onionrings;
import DrinksDecorators.Coffee;
import DrinksDecorators.Coke;
import Meal.Meal;
import Meal.BeefPizza;
import Meal.VegPizza;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);
        Meal meal;
        System.out.println("Please Select Your meal");
        System.out.println("1.Beef Pizza With French Fry");
        System.out.println("2.Veggi Pizza With Onion Rings");
        System.out.println("3.A combo meal with Veggi Pizza, French Fry and Coke");
        System.out.println("4.A combo meal with Veggi Pizza, Onion Rings and Coffee");
        System.out.println("5.A Beef Pizza only");
        while (true) {
            int choice = sc.nextInt();
            if (choice == 1) {
                meal = new FrenchFries(new BeefPizza());
            } else if (choice == 2) {
                meal = new Onionrings(new VegPizza());
            } else if (choice == 3) {
                meal = new Coke(new FrenchFries(new VegPizza()));
            } else if (choice == 4) {
                meal = new Coffee(new Onionrings(new VegPizza()));
            } else if(choice==5) {
                meal = new BeefPizza();
            }
            else break;
            System.out.println("Items in your meal are :");
            System.out.println(meal.prepareFood());
            System.out.println("Total Price :" + meal.price() + " BDT");
        }
    }
}
