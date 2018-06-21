package com.du.test0;

import com.du.util.String.StrUtil;

public class ToString {
    public static void main(String[] args) {
        test();
    }

    private static void test(){
        Long id = null;
        //id为null是下面的操作会报NullPointerException
        //String idToString = id.toString();
        //System.out.println(id+"-------"+idToString);
        String idValueOfString = String.valueOf(id);
        System.out.println(id+"-------"+idValueOfString);
        if(idValueOfString != null){
            System.out.println(idValueOfString+" != null");
        }else {
            System.out.println(idValueOfString + " == null");
        }
        if(StrUtil.isNoNULL(idValueOfString)){
            System.out.println(idValueOfString +" is not null and is not equals to null");
        }else{
            System.out.println(idValueOfString +" is null or is equals to null");
        }
    }
}
