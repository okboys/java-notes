package cn.com.time.jdk.lang.bits;

/**
 * Created on 202017/10/26 13:43 By tong.luo
 * <p>
 * Copyright @ 2017 Tima Networks Inc. All Rights Reserved. 
 */
public class BitsTest {

    public static void t1(){
        System.out.println(Integer.toBinaryString(~((1<<5)-1)));
        System.out.println(3>>-1);

    }

}
