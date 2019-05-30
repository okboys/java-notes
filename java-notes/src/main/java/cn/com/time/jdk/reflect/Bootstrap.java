package cn.com.time.jdk.reflect;

import cn.com.time.jdk.reflect.clazz.A;
import cn.com.time.jdk.reflect.clazz.B;
import cn.com.time.jdk.reflect.clazz.C;

public class Bootstrap {

    public static void main(String[] args) {
        System.out.println(B.class.isAssignableFrom(B.class));
    }

}
