package cn.com.time.jdk.lang.jni;

/**
 * Created on 202017/9/28 9:46 By tong.luo
 * <p>
 * Copyright @ 2017 Tima Networks Inc. All Rights Reserved. 
 */
public class Bootstrap {

    public static void main(String[] args) {
//        System.loadLibrary("sample");
//        Sample sample=new Sample();
//        int square=sample.intMethod(1);
//        boolean bool=sample.boolMethod(false);
    }

}
class MySample{
    public native int intMethod(int n);

    public native boolean boolMethod(boolean bool);

    public native String stringMethod(String trext);

    public native int intArrayMethod(int[] inttArray);
}
