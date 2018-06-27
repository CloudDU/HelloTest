package com.du.test0.sout;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author XP_IS_BUG
 * @date 2018/6/25
 */

/**
 * 通过反射修改final 类型的值
 */
public class Sout {
	public static void main(String[] args) throws Exception {
		Person1.main(args);
	}
}

class Person1{
	public static void main(String[] args) throws Exception {
		Person1 p = new Person1();
		Field field = p.getClass().getDeclaredField("NAME");
		Field modifiers = field.getClass().getDeclaredField("modifiers");
		modifiers.setAccessible(true);
		modifiers.setInt(field, field.getModifiers() & ~Modifier.FINAL);//final标志位置0
		field.set(p,"HELLO");
		System.out.println(field.get(p));
		p.printName();
	}

	private final static String NAME=(null != null ?"0": "xpxp");

	public Person1() {
	}

	public void printName(){
		System.out.println(NAME);
	}
}
