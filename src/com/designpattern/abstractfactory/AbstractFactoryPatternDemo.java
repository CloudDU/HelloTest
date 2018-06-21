package com.designpattern.abstractfactory;

import com.designpattern.factory.Shape;
import com.designpattern.factory.ShapeEnum;

public class AbstractFactoryPatternDemo {
    public static void main(String[] args) {
        //获取形状工厂
        AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");

        //获取形状为circle的对象
        Shape shape =  shapeFactory.getShape(ShapeEnum.RECTANGLE.value);
        shape.draw();

        //获取颜色工厂
        AbstractFactory colorFactory = FactoryProducer.getFactory("color");
        Color color = colorFactory.getColor(ColorEnum.BLUE.value);
        color.fill();

    }
}
