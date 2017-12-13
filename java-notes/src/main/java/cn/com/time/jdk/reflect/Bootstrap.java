package cn.com.time.jdk.reflect;

import cn.com.time.jdk.reflect.clazz.A;
import cn.com.time.jdk.reflect.clazz.B;
import cn.com.time.jdk.reflect.clazz.C;

/**
 * Created on 202017/10/9 9:45 By tong.luo
 * <p>
 * Copyright @ 2017 Tima Networks Inc. All Rights Reserved. 
 */
public class Bootstrap {

    public static void main(String[] args) {
        System.out.println(B.class.isAssignableFrom(B.class));
    }

}
