package com.designpattern.factory;

public enum  ShapeEnum {
    CIRCLE("CIRCLE"), RECTANGLE("RECTANGLE"), SQUARE("SQUARE");
    public String value;

    private ShapeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
