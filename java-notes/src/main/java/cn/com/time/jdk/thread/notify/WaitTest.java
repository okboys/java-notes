package cn.com.time.jdk.thread.notify;

import java.util.Vector;

/**
 * Created on 202017/10/27 17:17 By tong.luo
 * <p>
 * Copyright @ 2017 Tima Networks Inc. All Rights Reserved. 
 */
public class WaitTest {

    public static void main(String[] args) throws InterruptedException {
        Vector<String> v=new Vector<>();
        A a=new A(v);
        B b=new B(v);
        a.start();
        Thread.sleep(100);
        b.start();
    }

}

class A extends Thread{

    private Vector<String> vector;

    public A(Vector<String> vector){
        this.vector=vector;
    }

    @Override
    public void run() {
        synchronized (vector){
            while (true){
                try {
                    System.out.println("WAIT");
                    vector.wait();
//                    vector.notify();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
class B extends Thread{

    private Vector<String> vector;

    public B(Vector<String> vector){
        this.vector=vector;
    }

    @Override
    public void run() {
        synchronized (vector){
            while (true){
                try {
                    vector.notify();
                    Thread.sleep(1000);
                    System.out.println("NOTIFY");
                    vector.wait();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

