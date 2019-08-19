package com.du.NIO.test0;

/**
 * @author XP_IS_BUG
 * @date 2018/6/22
 */
public class StreamTest {
/**
	 * 1. InputStream/Reader
	 * int read() 从输入流中农读取单个字节/字符，返回所有读取的字节/字符数据（字节数据可直接转换为int类型）
	 * int read(byte[]/char[] b) 从输入流中最多读取b.length个字节/字符的数据，并将其存储在字节/字符数组中，返回实际读取的字节/字符数组
	 * int read(byte[]/char[] b, int off, int len) 从输入流中最多读取len个字节/字符的数据，并将其存储在数组中，放入数组b中时，
	 *      并不是从数组起点开始，而是从off位置开始，返回实际读取的字节/字符数
	 * void mark(int readAheadLimit) 在记录指针当前位置记录一个标记（mark）
	 * boolean markSuppoted() 判断此输入流是否支持mark()操作，即是否支持记录标记
	 * void reset() 将此流的记录指针重新定位到上一次记录标记(mark)的位置
	 * long skip(long n) 记录指针向前移动n个字节/字符
	 *
	 *
	 * 2.OutputStream/Writer
	 * void write(int c) 将指定的字节/字符输出到输出流中，其中c代表字节/字符
	 * void write(byte[]/char[] buf) 将字节/字符数组中的数据出书到指定的输出流中
	 * void write(byte[]/char[] buf, int off, int len) 将字节/字符数组中从off位置开始，长度为len的字节/字符输出到输出流中
	 *
	 * 因为字符流直接以字符串为操作单位，所以Writer可以用字符串来代替字符数组，即以String对象作为参数，故Writer有：
	 *  void write(String str) 将str字符串里包含的字符输出到指定的输出流中
	 *  void write(String str, int off, int len) 将str字符串里面从off位置开始，长度为len的字符输出到指定输出流中
	 *
	 */
}
