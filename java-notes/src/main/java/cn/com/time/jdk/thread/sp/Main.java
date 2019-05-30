package cn.com.time.jdk.thread.sp;

import java.util.Vector;

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
