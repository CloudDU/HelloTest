package com.du.util.String;

import java.util.Objects;

/**
 * 字符串工具类
 */
public class StrUtil {

    /**
     * 判断字符串是否不为空【包括null,即不存在】
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str){
        if(str == null){
            return false;
        }
        if(str.length() > 0){
            return true;
        }else{
            return false;
        }
    }

    //默认的分隔符
    private final static String SEPARATER = "-";

    /**
     * 字符串重复追加length次
     * @param s
     * @param length
     * @return
     */
    public static String repeat(String s, int length){
        if(s == null){
            return null;
        }
        if(length>0) {
            StringBuilder sb = new StringBuilder(s);
            for (int i = 0; i < length; i++) {
                sb.append(s);
            }
            return sb.toString();
        }else{
            return "";
        }
    }

    /**
     * 带有分隔符默认是“-”的重复srcStr length次
     * @param srcStr
     * @param length
     * @return
     */
    public static String repeatWithSeparator(String srcStr, int length){
        return  repeatWithSeparator(srcStr, SEPARATER, length);
    }

    /**
     * 自定义分隔符重复srcStr length次
     * @param srcStr
     * @param separater
     * @param length
     * @return
     */
    public static String repeatWithSeparator(String srcStr, String separater, int length){
        Objects.requireNonNull(srcStr,"The string must not be null");
        String s = repeat(srcStr+separater, length);
        return s.length() > 0 ? s.substring(0,s.length()-1): s;
    }

    /**
     * 判断字符串s不为null（不存在），且不为"null"。
     * @param s
     * @return
     */
    public static Boolean isNoNULL(String s){
        return s != null && !s.equalsIgnoreCase("null");
    }


}
