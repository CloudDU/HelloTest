package com.designpattern.builder;

public class BuilderDemo {
    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();
        Meal vegMeal = mealBuilder.prepareVegMeal();
        System.out.println("Veg Meal: ");
        vegMeal.showItems();
        System.out.println("Total cost: "+vegMeal.getCost());

        Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
        System.out.println("\n\nNonVeg Meal");
        nonVegMeal.showItems();
        System.out.println("Total cost: "+nonVegMeal.getCost());
    }
}
