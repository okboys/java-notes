package cn.com.time.jdk.thread.notify;

import java.util.Vector;

/**
 * Created on 202017/10/27 16:15 By tong.luo
 * <p>
 * Copyright @ 2017 Tima Networks Inc. All Rights Reserved. 
 */
public class NotifyTest {

    private Object OBJECT=new Object();

    public static void main(String args[]) {
        Vector obj = new Vector();
        Thread consumer = new Thread(new Consumer(obj));
        Thread producter = new Thread(new Producter(obj));
        consumer.start();
        producter.start();
    }

}

/*消费者 */
class Consumer implements Runnable {
    private Vector obj;
    public Consumer(Vector v) {
        this.obj = v;
    }
    public void run() {
        synchronized(obj) {
            while (true) {
                try {
//                    if (obj.size() ==0){
//                        obj.wait();
//                    }
                    System.out.println("Consumer:goods have been taken");
                    System.out.println("obj size: " + obj.size());
                    obj.clear();
                    obj.notify();
                }
                catch(Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

/*  生产者 */
class Producter implements Runnable {
    private Vector obj;
    public Producter(Vector v) {
        this.obj = v;
    }
    public void run() {
        synchronized(obj) {
            while (true) {
                try {
                    if (obj.size() !=0){
                        obj.wait();
                    }

                    obj.add(new String("apples"));
                    obj.notify();
                    Thread.sleep(5000);
                    System.out.println("Producter:obj are ready");

                }
                catch(Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
