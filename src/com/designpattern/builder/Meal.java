package com.designpattern.builder;


import java.util.ArrayList;
import java.util.List;

/**
 * 创建Meal类，带有已定义的Item对象
 */
public class Meal {
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item){
        items.add(item);
    }

    public float getCost(){
        float cost = 0.0f;
        for(Item item:items){
            cost += item.price();
        }
        return cost;
    }

    public void showItems(){
        for(Item item: items){
            System.out.print("Item: "+ item.name());
            System.out.print(",packing: "+ item.packing().pack());
            System.out.println(",price: "+ item.price());
        }
    }
}
