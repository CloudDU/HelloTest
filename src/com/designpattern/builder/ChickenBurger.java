package com.designpattern.builder;

/**
 * 创建扩展了Burger的实体类
 */
public class ChickenBurger extends Burger{
    @Override
    public float price() {
        return 50.0f;
    }

    @Override
    public String name() {
        return "Chicken Burger";
    }
}
