package com.designpattern.abstractfactory;

import com.designpattern.factory.Shape;

public class ColorFactory extends AbstractFactory {
    @Override
    public Color getColor(String color) {
        if(color == null){
            return null;
        }
        if(color.equals(ColorEnum.BLUE.value)){
            return new Blue();
        }else if(color.equals(ColorEnum.RED.value)){
            return new Red();
        }else if(color.equals(ColorEnum.GREEN.value)){
            return new Green();
        }
        return null;
    }

    @Override
    public Shape getShape(String shape) {
        return null;
    }
}
