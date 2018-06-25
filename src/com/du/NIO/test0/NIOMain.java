package com.du.NIO.test0;

import com.du.NIO.util.NIOUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.Selector;

public class NIOMain {
    private static final String filePath = "e:" + File.separator + "txt.txt";

    public static void main(String[] args) {
        /*try {
            readNIO();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        /* try {
            writeNIO("hello world! 哈喽，世界！");
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        String txt = "\r\n-1-2-1-2-1-2-1-2\t哈莎莎\t的快速和许安安";
        try {
            //NIOUtil.writeToFile(txt, filePath);
            NIOUtil.appendWriteToFile(txt, filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            NIOUtil.readFromFile(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private static void testSelector() throws IOException {
        Selector selector = Selector.open();
    }
    private static void writeNIO(String message) throws IOException {
        /**
         * 1. 获取一个通道
         */
        FileOutputStream fout = new FileOutputStream("e:\\txt.txt");
        FileChannel fc = fout.getChannel();

        /**
         * 2.创建缓冲区，将数据放入到缓冲区
         */
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put(message.getBytes());
        buffer.flip();


        /**
         * 3. 把缓冲区数据写入到通道中
         */
        fc.write(buffer);

    }


    /**
     * 读文件练习
     *
     * @throws IOException
     */
    private static void readNIO() throws IOException {

        /**
         * 1.下面两步是获取通道
         */
        FileInputStream fin = new FileInputStream("e:\\txt.txt");
        FileChannel fc = fin.getChannel();

        /**
         * 2.创建缓冲区
         */
        ByteBuffer buffer = ByteBuffer.allocate(1024 * 10);

        /**
         * 3.将数据从通道读到缓冲区
         */
        fc.read(buffer);

        System.out.println(new String(buffer.array()));
    }
}
