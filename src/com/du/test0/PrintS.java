package com.du.test0;

public class PrintS {
  
    public static void main(String arg[]) {
        System.out.println("A"+new PrintS());

    }
    public String toString() {
        System.out.print("B");
        return "C";
    }
    public PrintS(){
        System.out.println("3");
        System.err.println("4");
    }
    static {
        System.out.println("1");
    }
    {
        System.out.println("2");
    }
}