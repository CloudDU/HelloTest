package com.du.test1.java8;

/**
 * 接口中也可以有默认方法，静态方法
 */
public interface Vehicle {
    //普通方法
    public void flag();

    //默认方法
    default void print(){
        System.out.println("我是一辆车");
    }

    //静态方法
    static void blowHorn(){
        System.out.println("按喇叭。");
    }
}
