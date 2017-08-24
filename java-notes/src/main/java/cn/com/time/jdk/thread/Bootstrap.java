package cn.com.time.jdk.thread;

import cn.com.time.jdk.thread.t.ThreadTest;

/**
 * Created by TimaNetworks on 2017/8/22.
 */
public class Bootstrap {

    public static void main(String[] args) {
        ThreadTest threadTest=new ThreadTest();
        threadTest.start();
        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("M M P");
            }
        },"My thread...");
    }

}
