package com.designpattern.factory;

/**
 * 创建三角形实现形状接口
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
