package com.designpattern.abstractfactory;

import com.designpattern.factory.Shape;

public abstract class AbstractFactory {
    public abstract Color getColor(String color);
    public abstract Shape getShape(String shape);
}
