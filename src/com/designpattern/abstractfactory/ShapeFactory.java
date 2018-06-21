package com.designpattern.abstractfactory;

import com.designpattern.factory.*;

public class ShapeFactory extends AbstractFactory {
    @Override
    public Color getColor(String color) {
        return null;
    }

    @Override
    public Shape getShape(String shapeType) {
        if(shapeType == null){
            return null;
        }
        if(shapeType.equals(ShapeEnum.CIRCLE.value)){
            return new Circle();
        }else if(shapeType.equals(ShapeEnum.RECTANGLE.value)){
            return new Rectangle();
        } else if (shapeType.equals(ShapeEnum.SQUARE.value)) {
            return new Square();
        }
        return null;
    }
}
