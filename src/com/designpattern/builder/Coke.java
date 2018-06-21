package com.designpattern.builder;

/**
 * 创建扩展了CodeDrink的实体类
 */
public class Coke extends CodeDrink {
    @Override
    public float price() {
        return 30.0f;
    }

    @Override
    public String name() {
        return "Coke";
    }
}
