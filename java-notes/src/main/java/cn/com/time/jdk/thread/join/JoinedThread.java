package cn.com.time.jdk.thread.join;

/**
 * Created on 2017/12/18 17:04
 *
 * @author: tong.luo
 * Copyright @2017 Tima Networks Inc. All Rights Reserved. 
 */
public class JoinedThread implements Runnable{
    @Override
    public void run() {
        System.out.println("JoinedThread executing");
    }
}
