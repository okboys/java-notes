package cn.com.time.jdk.thread.sp;

import java.util.Vector;

/**
 * Created on 2017/12/18 14:43
 *
 * @author: tong.luo
 * Copyright @2017 Tima Networks Inc. All Rights Reserved. 
 */
public class Main {

    public static void main(String[] args) {
        Vector<String> vector=new Vector<>();
        Consumer consumer=new Consumer(vector);
        Producer producer=new Producer(vector);
        new Thread(consumer).start();
        new Thread(producer).start();
        new Thread(producer).start();
        new Thread(producer).start();
    }

}
