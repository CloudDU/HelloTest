package com.du.test0.sout;

/**
 * @author XP_IS_BUG
 * @date 2018/6/25
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * 设置输出方式，控制台/文件
 */
public class Sout2 {
	public static void main(String[] args) {
		try {
			test2();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * System.out
	 * @throws FileNotFoundException
	 */
	private static void test() throws FileNotFoundException {
		PrintStream old = System.out;
		PrintStream ps = new PrintStream(new File("E:"+File.separator+"log.txt"));
		System.setOut(ps);
		System.out.println("这段内容会输出到e:/log.txt里...");
		System.setOut(old);
		System.out.println("hello world!");
	}

	/**
	 * System.err
	 */
	private static void test2() throws FileNotFoundException {
		PrintStream old = System.err;
		PrintStream ps = new PrintStream(new File("E:"+File.separator+"err.txt"));
		//System.setOut(old); 这个是无法重定向err的，应该是：
		System.setErr(ps);
		System.err.println("这段错误信息会输出到err.txt里吗？ 控制台能看到吗？");
		System.setErr(old);
		System.err.println("hello errors!");
	}

}
