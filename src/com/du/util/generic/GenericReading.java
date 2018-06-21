package com.du.util.generic;

import java.util.Arrays;
import java.util.List;

public class GenericReading {
    static List<Apple> apples = Arrays.asList(new Apple());
    static List<Fruit> fruits = Arrays.asList(new Fruit());

    static class Reader<T>{
        T readExact(List<T> list){
            return list.get(0);
        }
    }

    static void f1(){
        Reader<Fruit> fruitReader = new Reader<Fruit>();
        //Errors List<Fruit> cannot be applied to List<Apple>
        //Fruit f = fruitReader.readExact(apples);
    }

    static class ConvarianReader<T>{
        T readConvariant(List<? extends  T> list){
            return list.get(0);
        }
    }

    static void f2(){
        ConvarianReader<Fruit> fruitConvarianReader = new ConvarianReader<Fruit>();
        Fruit f = fruitConvarianReader.readConvariant(fruits);
        Fruit a = fruitConvarianReader.readConvariant(apples);
    }

    public static void main(String[] args) {
        f1();
        f2();
    }


}

class Node<T extends Comparable<T>>{
    private T data;
    private Node<T> next;
    public Node(T data, Node<T> next){
        this.data = data;
        this.next = next;
    }
}
