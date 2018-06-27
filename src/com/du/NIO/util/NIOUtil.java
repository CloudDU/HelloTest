package com.du.NIO.util;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * nio 工具类
 */
public class NIOUtil {


    /**
     * 向文件中写入数据
     * @param txt
     * @param filePath
     * @throws IOException
     */
    public static void writeToFile(String txt, String filePath) throws IOException {
        FileOutputStream fout = new FileOutputStream(filePath);
        FileChannel fc = fout.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        txt = txt == null ? "null" : txt;
        buffer.put(txt.getBytes());

        buffer.flip();
        fc.write(buffer);
    }

    /**
     * 从文件中读取文件
     * @param filePath
     * @throws IOException
     */
    public static void readFromFile(String filePath) throws IOException {
        FileInputStream fin = new FileInputStream(filePath);
        FileChannel fc = fin.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        fc.read(buffer);
        print(new String(buffer.array()));
    }


    /**
     * 追加内容到文件中
     * @param txt
     * @param filePath
     */
    public static void appendWriteToFile(String txt, String filePath) throws IOException {
        txt = txt == null ? "null" :txt;
        if(txt.isEmpty()){
            return;
        }
        FileOutputStream fout = new FileOutputStream(filePath, true);
        FileChannel fc = fout.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(2048);
        buffer.put(txt.getBytes());

        buffer.flip();
        fc.write(buffer);
    }

    /**
     * 打印内容
     * @param s
     */
    private static void print(String s){
        System.out.println(s);
    }

    /**
     * 复制文件
     * @param src
     * @param dst
     * @throws IOException
     */
    public static void copyFile(String src, String dst) throws IOException {
        //声明源文件和目的文件
        FileInputStream fin = new FileInputStream(new File(src));
        FileOutputStream fout = new FileOutputStream(new File(dst));
        //获得传输通道channel
        FileChannel inChannel = fin.getChannel();
        FileChannel outChannel = fout.getChannel();
        //获得容器buffer
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while(true){
            //判断是否读完文件
            int eof = inChannel.read(buffer);
            if(eof == -1){
                break;
            }
            //重设一下buffer的position=0, limite=position
            buffer.flip();
            //开始写
            outChannel.write(buffer);
            //写完要重置buffer,重设position=0,limit=capacity
            buffer.clear();
        }
        inChannel.close();
        outChannel.close();
        fin.close();
        fout.close();

    }
}
