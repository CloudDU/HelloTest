package com.du.util.generic.bridgemethod;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws Exception {
        AClass aClass = new AClass();
        aClass.method("hello");
        Method m = AClass.class.getMethod("method",String.class);
        m.invoke(aClass,"xxxxxxxxxxxxxxxxxxxxx");
        System.out.println(m.isBridge());
        m = AClass.class.getMethod("method",Object.class);
        m.invoke(aClass,"&&&&&&&&&&&&&&&&&&&&&&&");
        System.out.println(m.isBridge());
    }

}
