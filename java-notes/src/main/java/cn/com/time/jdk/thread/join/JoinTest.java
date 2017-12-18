package cn.com.time.jdk.thread.join;

/**
 * Created on 2017/12/18 16:52
 *
 * @author: tong.luo
 * Copyright @2017 Tima Networks Inc. All Rights Reserved. 
 */
public class JoinTest{

    public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(new JoinedThread());
        Thread t2=new Thread(new CentralThread(t1));

        t1.start();
        t2.start();

        System.out.println("Thread ended");
        t2.join();
    }

}
