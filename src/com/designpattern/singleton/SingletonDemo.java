package com.designpattern.singleton;

public class SingletonDemo {
    public static void main(String[] args) {
        //不合法的构造函数
        //编译时错误：构造函数SingletonObject()是不可见的
        //SingletonObject singletonObject = new SingletonObject();

        //获取唯一的可用的对象
        SingletonObject object = SingletonObject.getInstance();
        //显示消息
        object.showMessage();
    }
}
