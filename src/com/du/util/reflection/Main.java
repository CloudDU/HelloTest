package com.du.util.reflection;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;

/**
 * @author XP_IS_BUG
 * @date 2018/6/27
 */
public class Main {
	String s = null;

	public static void main(String[] args) {
		PersonObj obj = new PersonObj();
		obj.setUserId(1L);
		obj.setUserName("xxx");
		obj.setUserNum(9919L);
		obj.setUserAge(0);
		obj.setUserBirth(new Date());
		obj.setUserWorkYear(2);
		obj.setCreationDate(new Date());
		obj.setLastChangedDate(new Date());
		obj.setIsDelete(0);

		List<Field> list = Reflection.getObjectAttr(obj);
		for(Field f: list){
			System.out.println(f.getName()+"---"+f);
		}

	}
}
