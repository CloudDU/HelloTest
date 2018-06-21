package com.du.jdktest.java8;

public class LamdaTest {
    public static void main(String[] args) {
        LamdaTest lt = new LamdaTest();

        //类型声明
        Mathoperation addition = (int a, int b) -> a + b;
        //不同类型声明
        Mathoperation subtraction = (a, b) -> a-b;
        //大括号中的返回语句
        Mathoperation multiplication = (int a, int b) -> {return a*b;};
        //没有大括号及返回语句
        Mathoperation division = (int a, int b) -> a/b;
        System.out.println("10+5="+lt.operate(10,5,addition));
        System.out.println("10-5="+lt.operate(10,5,subtraction));
        System.out.println("10*5="+lt.operate(10,5,multiplication));
        System.out.println("10/5="+lt.operate(10,5,division));

        final String Hello = "hello";
        //不用括号
        GreetingService greetingService1 = message -> System.out.println(Hello+" "+message);
        //用括号
        GreetingService greetingService2 = (message) -> {System.out.println(Hello+" "+message);};

        greetingService1.sayMessage("World");
        greetingService2.sayMessage("world");
    }

    interface gitMathoperation{
        int operation(int a, int b);
    }

    interface GreetingService{
        void sayMessage(String message);
    }

    private int operate(int a, int b, Mathoperation mathoperation){
        return mathoperation.operation(a, b);
    }
}
