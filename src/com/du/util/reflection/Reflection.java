package com.du.util.reflection;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author XP_IS_BUG
 * @date 2018/6/27
 */
public class Reflection {

	/**
	 * 获得对象属性列表
	 * @param obj
	 * @return
	 */
	public static List<Field> getObjectAttr(Object obj){
		Class<?> cls = obj.getClass();
		Field[] fields = null;
		fields = cls.getDeclaredFields();
		Field[] superFields = null;
		if(null != cls.getGenericSuperclass()){
			Class<?> superCls = cls.getSuperclass();
			superFields = superCls.getDeclaredFields();
		}
		List<Field> allFieldList= null;
		if(null != superFields){
			allFieldList = new ArrayList<>();
			List<Field> list1 = Arrays.asList(fields);
			List<Field> list2 = Arrays.asList(superFields);
			allFieldList.addAll(list1);
			allFieldList.addAll(list2);
		}
		return allFieldList;
	}
}
