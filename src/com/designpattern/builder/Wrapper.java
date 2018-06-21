package com.designpattern.builder;

/**
 * 创建实现Packing接口的实体类
 */
public class Wrapper implements Packing{
    @Override
    public String pack() {
        return "wrapper";
    }
}
