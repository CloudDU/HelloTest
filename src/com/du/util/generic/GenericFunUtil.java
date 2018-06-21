package com.du.util.generic;

import javafx.util.Pair;

public class GenericFunUtil {
    //比较
    public static <K, V> boolean compare(Pair<K, V>p1, Pair<K,V>p2){
        return p1.getKey().equals(p2.getKey())&&p1.getValue().equals(p2.getValue());
    }

    //查找泛型数组中大于某个特定元素的个数
    public static <T extends Comparable<T>> int countGreaterThan(T[] array, T elem){
        int count = 0;
        for (T e: array){
            if(e.compareTo(elem) > 0){
                ++count;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Pair<Integer, String> p1 = new Pair<>(1,"apple");
        Pair<Integer, String> p2 = new Pair<>(2,"pear");
        System.out.println(GenericFunUtil.compare(p1,p2));
    }
}
