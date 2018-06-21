package com.designpattern.builder;

/**
 * 创建扩展了CodeDrink的实体类
 */
public class Pepsi extends CodeDrink {
    @Override
    public float price() {
        return 35.0f;
    }

    @Override
    public String name() {
        return "Pepsi";
    }
}
