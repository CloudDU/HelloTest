package com.designpattern.abstractfactory;

public enum ColorEnum {
    RED("RED"),BLUE("BLUE"),GREEN("GREEN");

    public String value;

    private ColorEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
