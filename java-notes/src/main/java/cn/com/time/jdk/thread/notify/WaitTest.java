package cn.com.time.jdk.thread.notify;

import java.util.Vector;

public class WaitTest {

    public static void main(String[] args) throws InterruptedException {
        Vector<String> v=new Vector<>();
        A a=new A(v);
        B b=new B(v);

        B c=new B(v);
        a.start();
        Thread.sleep(100);
        b.start();
        c.start();
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
            System.out.println("Thread A obtain lock.");
            while (true){
                try {
                    System.out.println("WAIT");
                    vector.wait();
                    vector.notify();


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
            System.out.println("Thread B obtain lock.");
            while (true){
                try {
//                    vector.notify();
                    Thread.sleep(1000);
                    System.out.println("NOTIFY");
                    vector.wait();
                    System.out.println("aaa");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

