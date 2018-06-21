package com.designpattern.builder;

/**
 * 创建扩展了Burger的实体类
 */
public class VegBurger extends Burger{
    @Override
    public float price() {
        return 25.0f;
    }

    @Override
    public String name() {
        return "Veg Burger";
    }
}
