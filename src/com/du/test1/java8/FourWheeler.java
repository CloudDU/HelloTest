package com.du.test1.java8;

public interface FourWheeler {
    public void flag();

    default void print(){
        System.out.println("我是一辆四轮车");
    }

    static void blowHorn(){
        System.out.println("按大喇叭。");
    }
}
