package com.du.test1.java8;

import com.du.util.String.StrUtil;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Tester {
    public static void main(String[] args) {
        List names = new ArrayList();
        names.add("Google");
        names.add("Facebook");
        names.add("VMware");
        names.add("Firefox");
        names.add("Apple");

        names.forEach(System.out::println);

        List<Integer> numli = Arrays.asList(1,2,3,4,5,6,7,8,90);
        System.out.println("输出所有数据：");
        /**
         * Predicate<Integer> predicate = n -> true;
         * n 是一个参数传递到Predicate接口的test方法
         * n 如果存在则test方法返回true
         */
        eval(numli, n->true);

        System.out.println("输出所有的偶数：");
        eval(numli, n->n%2==0);

        System.out.println(StrUtil.repeat("=", 21));

        Car c =  new Car();
        c.flag();
        c.print();

        System.out.println(StrUtil.repeat("*",30));
        System.out.println(StrUtil.repeatWithSeparator("*",30));
        System.out.println(StrUtil.repeatWithSeparator("*","^",30));
        System.out.println(StrUtil.repeatWithSeparator(":","^",30));
        System.out.println(StrUtil.isNotEmpty("null"));

        test();
        test2();
        test3();
    }

    //Stream测试
    private static void test(){
        Random random  = new Random();
        random.ints().limit(10).sorted().forEach(System.out::println);
        System.out.println(StrUtil.repeatWithSeparator("@","~",30));
        List<String> strings = Arrays.asList("abc","","bc","efg","abcd","jkl");
        //获取空字符串数量
        long count = strings.parallelStream().filter(string -> string.isEmpty()).count();
        System.out.println(count);

        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println("筛选列表："+filtered);
        String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(","));
        System.out.println("合并字符串："+mergedString);
        List<Integer> numbers = Arrays.asList(3,2,2,3,7,3,5);
        IntSummaryStatistics stats = numbers.stream().mapToInt((x)-> x).summaryStatistics();
        System.out.println("列表中最大的数："+stats.getMax());
        System.out.println("列表中最小的数："+stats.getMin());
        System.out.println("所有数之和："+stats.getSum());
        System.out.println("平均数："+stats.getAverage());
    }

    /**
     * Optional测试
     */
    private static void test2(){
        Integer value1 = null;
        Integer value2 = 10;
        //Optional.ofNullable -  允许传递为null的参数
        Optional<Integer> a = Optional.ofNullable(value1);
        //Optional.of - 如果传递的参数为null，抛出异常nullpointerException
        Optional<Integer> b = Optional.of(value2);
        System.out.println(sum(a,b));


    }

    private static Integer sum(Optional<Integer> a, Optional<Integer>b){
        //Optional.isPresent(); 判断值是否存在
        System.out.println("第一个参数值存在："+a.isPresent());
        System.out.println("第二个参数值存在："+b.isPresent());

        //Optional.orElse() - 如果值存在，返回它， 否则返回默认值
        Integer value1 = a.orElse(0);

        //Optional.get - 获取值，值需要存在
        Integer value2 = b.get();
        return value1 + value2;
    }


    //Nashorn Javascript
    //Nashorn取代Rhino(JDK 1.6, JDK1.7)成为Java的嵌入式JavaScript引擎
    private static void test3(){

        //java 中调用js
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine nashorn = scriptEngineManager.getEngineByName("nashorn");

        String name = "dangdang";
        Integer result = null;

        try {
            nashorn.eval("print('"+name+"')");
            result = (Integer) nashorn.eval("10+2");
        } catch (ScriptException e) {
            System.out.println("执行脚本错误："+e.getMessage());
        }
        System.out.println(result.toString());


        //js 中调用java
    }


    private static void eval(List<Integer> list, Predicate<Integer> predicate){
        for(Integer i: list){
            if(predicate.test(i)){
                System.out.println(i+" ");
            }
        }
    }
}

class Car implements Vehicle, FourWheeler{
    @Override
    public void flag() {
        System.out.println("OOOOO");
    }

    @Override
    public void print() {
        Vehicle.super.print();
    }
}
