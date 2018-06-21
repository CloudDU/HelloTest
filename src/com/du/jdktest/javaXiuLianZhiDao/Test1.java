package com.du.jdktest.javaXiuLianZhiDao;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;

import static java.nio.file.StandardWatchEventKinds.*;

/**
 * Created by ducheng on 2017-11-09.
 */
public class Test1 {
    public static void main(String[] args) throws IOException {
        //printSwitchString("Sunday");
        //printBinaryNumber("1100110");

        printFilePath();
        //operatorFile();

        //watchFile();

        //砖石语法，不用将等号右边的全部写全。
        Map<Integer, Map<String, String>> userList = new HashMap<>();

        //不能写 HashMap<String, String>[] arr = new HashMap<>[2];
        //只能写
        HashMap<String, String>[] arr = new HashMap[2];

    }

    /*private Configuration getConfig(String fileName){
        Configuration cfg = null;
        String fileText = getFile(fileName);
    }*/


    /**
     * 2
     * binary number & long number has "_" bound symbol
     * @param _number
     */
    private static void printBinaryNumber(String _number){
        System.out.println("origin number is : "+ _number);
        int x = Integer.parseInt(_number, 2);
        System.out.println("converted number is : "+x);
        System.out.println("-------------------------------");
        String binNumber = "0b"+_number;

        int num = 0b1100110;        //java7 new point
        System.out.println(num);
        System.out.println(0b001_1100_0011_0010_1011__1010_0011);
    }

    /**
     * 1
     * Switch has String case.
     * @param _string
     */
    private static void printSwitchString(String _string) {
        switch (_string) {
            case "Sunday":
                System.out.println("Dimanche");
                break;
            case "Monday":
                System.out.println("Lundi");
                break;
            case "Tuesday":
                System.out.println("Mardi");
                break;
            case "Wednesday":
                System.out.println("Mercredi");
                break;
            case "Thursday":
                System.out.println("Jeudi");
                break;
            case "Friday":
                System.out.println("Vendredi");
                break;
            case "Saturday":
                System.out.println("Samedi");
                break;
            default:
                System.out.println("Error: '"+_string + "' is not a day of the week.");
                break;
        }
    }


    /**
     * file test
     * @throws IOException
     */
    private static void printFilePath() throws IOException {
        Path listings = Paths.get("E:/workspace_IJ/HelloTest/src");
        System.out.println(listings+"      ///////////////////");
        System.out.println(listings.getFileName());     //获取文件名
        System.out.println(listings.getNameCount());    //获取路径长度
        System.out.println(listings.getParent());       //获取当前目前的父目录
        System.out.println(listings.getRoot());         //获取根目录
        System.out.println(listings.subpath(0,2));      //获取从0到1的路径
        System.out.println(listings.normalize());
        System.out.println(listings.toRealPath());
        System.out.println();
        Path pathFile = Paths.get("e:/dc/MyTest.txt");
        System.out.println(pathFile.getFileName());     //获取文件名
        System.out.println(Files.getLastModifiedTime(pathFile));        //文件最后修改时间
        System.out.println(Files.size(pathFile));                       //文件大小
        System.out.println(Files.isSymbolicLink(pathFile));             //是否是符号链接
        System.out.println(Files.isDirectory(listings));                //文件是否是目录
        System.out.println("***********");
        System.out.println(Files.readAttributes(pathFile,"*"));   //读取文件所有属性
        System.out.println("----------------------------");
        Files.walkFileTree(listings, new FindJavaFile());
        System.out.println("--------------------------------");
        Path listings2 = FileSystems.getDefault().getPath("/dc/7-13");
        System.out.println(listings2+"    \\\\\\\\\\\\\\\\\\\\\\\\\\");
        System.out.println(listings2.toAbsolutePath()+"  ????????");
        System.out.println(System.getSecurityManager());
    }


    /**
     * 查找文件目录下的.java文件
     */
    private static class FindJavaFile extends SimpleFileVisitor<Path>{
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
            if (file.toString().endsWith(".java")){
                System.out.println(file.getFileName());
            }
            return FileVisitResult.CONTINUE;
        }
    }

    private static void operatorFile() throws IOException {

        //创建文件
        Path target = Paths.get("e:/dc/.MyTest.sh");
      //  Files.createFile(target);

        //复制文件
        Path source = Paths.get("e:/dc/MyTest.txt");
        Path target1 = Paths.get("D:/Youdao/MyTest2.txt");
        Files.copy( target1,source, StandardCopyOption.REPLACE_EXISTING);      //复制文件操作，最后一个参数表示覆盖即替换已有文件

        //移动文件
        Path target2 = Paths.get("D:/Youdao/test/MyTest3.txt");
        //Files.move(source, target2,StandardCopyOption.REPLACE_EXISTING);       //移动文件操作
    }

    private static void watchFile(){
        try {
            WatchService watchService = FileSystems.getDefault().newWatchService();
            Path dir = FileSystems.getDefault().getPath("D:/Youdao/");
            WatchKey key = dir.register(watchService, new WatchEvent.Kind[]{ENTRY_MODIFY,ENTRY_CREATE,ENTRY_DELETE});

            System.out.println(key);
            while(1==1){
                key = watchService.take();
                for(WatchEvent<?> event: key.pollEvents()){
                    if(event.kind() == ENTRY_MODIFY){
                        System.out.println("Home dir changed!");
                        System.out.println(event.context()+"修改了!!!!");
                    }else if(event.kind() == ENTRY_CREATE){
                        System.out.println("new file created");
                        System.out.println(event.context()+"新建了!!!!");
                    }else if(event.kind() == ENTRY_DELETE){
                        System.out.println("file has deleted");
                        System.out.println(event.context()+"被删除了!!!!");
                    }
                }
                key.reset();
            }
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
