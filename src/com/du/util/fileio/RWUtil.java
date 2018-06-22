package com.du.util.fileio;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.io.Writer;

/**
 * @author XP_IS_BUG
 * @date 2018/6/22
 */
public class RWUtil {

	/**
	 * 用字节流写文件
	 * @param txt 文本内容
	 * @param filePath 文件路径及文件名
	 */
	public static void writeByteToFile(String txt, String filePath) throws IOException {

		txt = txt == null ? "null" : txt;

		byte[] bytes = txt.getBytes();
		File file = new File(filePath);
		OutputStream os = new FileOutputStream(file);
		os.write(bytes);
		os.close();
	}


	/**
	 * 用字节流读取文件
	 * @param filePath 文件路径及文件名
	 */
	public static void readByteFromFile(String filePath) throws IOException{
		File file = new File(filePath);
		byte[] bytes = new byte[(int)file.length()];
		InputStream is = new FileInputStream(file);
		int size = is.read(bytes);
		printFileInfo(filePath, size, new String(bytes));
		is.close();
	}


	/**
	 * 用字符流写入文件
	 * @param txt 待写入文件内容
	 * @param filePath 文件路径及文件名
	 */
	public static void writeCharToFile(String txt, String filePath) throws IOException{
		txt = txt == null ? "null" : txt;
		File file = new File(filePath);
		Writer os = new FileWriter(file);
		os.write(txt);
		os.close();
	}


	/**
	 * 用字符流读文件
	 * @param filePath
	 */
	public static void readCharFromFile(String filePath) throws IOException{
		File file = new File(filePath);
		Reader reader = new FileReader(file);
		char[] byteArray = new char[(int)file.length()];
		int size = reader.read(byteArray);
		printFileInfo(filePath, size, new String(byteArray));
		reader.close();
	}


	/**
	 * 将字节流转换为字符流
	 * @param filePath
	 * @throws IOException
	 */
	public static void convertByteToChar(String filePath) throws IOException{
		File file = new File(filePath);
		//获得一个字节流
		InputStream is = new FileInputStream(file);
		//把字节流转换为字符流，其实就是把字符流和字节流组合的结果
		Reader reader = new InputStreamReader(is);
		char[] byteArray = new char[(int)file.length()];
		int size = reader.read(byteArray);
		printFileInfo(filePath, size, new String(byteArray));
		is.close();
		reader.close();
	}

	/**
	 * 打印文件信息
	 * @param filePath
	 * @param size
	 * @param info
	 */
	private static void printFileInfo(String filePath, int size, String info){
		System.out.println("读取文件："+filePath+", 文件大小："+size+", 内容："+info);
	}


	/**
	 *
	 * 上面的方法是通过字节流和字符流的方式读写文件，但是只能通从文件头读写到文件结尾，不能随机读写。
	 * 下面的方法支持随机读写文件
	 *
	 * 随机读取文件
	 * @param filePath 文件路径及文件名
	 * @param mode 读写方式
	 */
	public static void randomAccessFileRead(String filePath, String mode) throws IOException{
		randomAccessFileReadWithPoint(filePath, mode, 0);
	}

	/**
	 * 随机读取文件
	 * @param filePath
	 * @param mode
	 * @param point
	 */
	public static void randomAccessFileReadWithPoint(String filePath, String mode, int point) throws IOException{
		//创建一个RandomAccessFile对象
		RandomAccessFile file = new RandomAccessFile(filePath, mode);
		//通过seek()来移动读写位置的指针
		file.seek(point);
		//获取当前指针
		long pointerBegin = file.getFilePointer();
		//从当前指针开始读
		byte[] contents = new byte[1024];
		int size = file.read(contents);
		long pointerEnd = file.getFilePointer();
		printFileInfo2(filePath, size, new String(contents), pointerBegin, pointerEnd);
		file.close();
	}


	/**
	 * 随机写文件
	 * @param filePath
	 * @param mode
	 */
	public static void randomAccessFileWrite(String filePath, String mode, String txt) throws IOException{
		randomAccessFileWriteWithPoint(filePath, mode, txt,0);
	}


	/**
	 * 随机写文件
	 * @param filePath
	 * @param mode
	 * @param point
	 */
	public static void randomAccessFileWriteWithPoint(String filePath, String mode, String txt, int point) throws IOException{
		//创建一个RandomAccessFile对象
		RandomAccessFile file = new RandomAccessFile(filePath, mode);
		//通过seek方法来移动读写位置的指针
		file.seek(point);
		//获取当前指针
		long pointerBegin = file.getFilePointer();
		//从当前指针位置开始写
		txt = txt == null ? "null" : txt;
		file.write(txt.getBytes());
		long pointerEnd = file.getFilePointer();
		printPointer(pointerBegin, pointerEnd);
		file.close();
	}

	/**
	 * 打印文件信息
	 * @param filePath
	 * @param size
	 * @param info
	 */
	private static void printFileInfo2(String filePath, int size, String info, long pointerBegin, long pointerEnd){
		printFileInfo(filePath, size, info);
		printPointer(pointerBegin, pointerEnd);
	}

	/**
	 * 打印指针位置（初始和结束）
	 * @param pointerBegin
	 * @param pointerEnd
	 */
	private static void printPointer(long pointerBegin, long pointerEnd){
		System.out.println("开始指针位置："+pointerBegin+", 结束指针位置："+pointerEnd);
	}


	/**
	 * 用缓冲流读文件
	 *
	 * 主要是为了提高IO效率，因为原始的InputStream对数据读取过程都是一个字节一个字节的操作的，
	 * 而BufferedInputStream在其内部提供了一个buffer，在读数据时，会一次读取一大块数据到buffer中。
	 *
	 * @param filePath
	 */
	public static byte[] readByBufferedInputStream(String filePath) throws IOException {
		File file = new File(filePath);
		byte[] byteArray = new byte[(int)file.length()];
		//可以在构造函数中传入buffer大小
		InputStream is = new BufferedInputStream(new FileInputStream(file), 2*1024);
		int size = is.read(byteArray);
		printFileInfo(filePath, size, new String(byteArray));
		is.close();
		return byteArray;
	}

	/**
	 *
	 * @param filePath
	 */
	public static char[] readByBufferedReader(String filePath) throws IOException{
		File file = new File(filePath);
		Reader reader = new BufferedReader(new FileReader(file), 2*1024);
		char[] byteArray = new char[(int)file.length()];
		int size = reader.read(byteArray);
		printFileInfo(filePath, size, new String(byteArray));
		reader.close();
		return byteArray;
	}


	/**
	 * 用字符流读文件
	 * @param filePath
	 */
	public static String readCharFromFileByReader(String filePath){
		File file = new File(filePath);
		Reader reader = null;
		try {
			reader = new FileReader(file);
			char[] byteArray = new char[(int)file.length()];
			reader.read(byteArray);
			return new String(byteArray);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
			}
		}
		return null;
	}

	/**
	 * 用字符流写入文件
	 * @param txt 待写入文件内容
	 * @param file 文件路径及文件名
	 */
	public static void writeToFile(String txt, File file) throws IOException{
		txt = txt == null ? "null" : txt;
		Writer os = new FileWriter(file);
		os.write(txt);
		os.close();
	}

	/**
	 * 文件复制
	 * @param source
	 * @param destination
	 */
	public static void fileCopy(String source, String destination) throws IOException{
		String txt = readCharFromFileByReader(source);
		txt = txt == null ? "" : txt;
		File file = new File(destination);
		if(file.exists()){
			writeToFile(txt, file);
		}else{
			if(file.mkdirs()){
				writeToFile(txt, file);
			}else{
				throw new IOException("创建"+destination+"路径失败");
			}
		}

	}


	/**
	 * 复制文件
	 * @param source
	 * @param destination
	 */
	public static void copyFile(String source, String destination){
		FileWriter w = null;
		FileReader r = null;
		try {
			r = new FileReader(source);
			w = new FileWriter(destination);

			//方式1：单个字符写入
			int temp = 0;
			while((temp = r.read()) != -1){
				w.write(temp);
			}

			//方式2： 字符数组方式写入
           /* char[] buf = new char[1024];
            int temp = 0;
            while((temp = r.read(buf)) != -1){
                w.write(new String(buf, 0, temp));
            }*/

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//分别判断是否空指针引用，然后关闭流
			if(r != null){
				try {
					r.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if(w != null){
				try {
					w.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
