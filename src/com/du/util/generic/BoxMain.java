package com.du.util.generic;

public class BoxMain {
    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<>();
        integerBox.setT(22);
        System.out.println(integerBox.getT());
        Box<String> stringBox = new Box<>();
        stringBox.setT("hello");
        System.out.println(stringBox.getT());

    }
}
