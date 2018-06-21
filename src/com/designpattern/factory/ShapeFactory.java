package com.designpattern.factory;

/**
 * 创建一个工厂，生成基于给定信息的实体类的对象
 */
public class ShapeFactory {

    public Shape getShape(String shapeType){
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
