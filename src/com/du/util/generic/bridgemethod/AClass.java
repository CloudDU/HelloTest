package com.du.util.generic.bridgemethod;

public class AClass implements SuperClass<String> {
    @Override
    public void method(String s) {
        System.out.println(s);
    }
}
