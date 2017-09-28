package cn.com.time.jdk.lang;

import com.mysql.jdbc.ConnectionImpl;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.sql.DriverManager;
import java.util.HashMap;

/**
 * Created by TimaNetworks on 2017/8/28.
 */
public class Bootstrap {

    public static void t1(){
        ReferenceQueue queue=new ReferenceQueue();
        Object o=new Object(){
            @Override
            public String toString() {
                return "Referenced Object";
            }
        };
        Object d=new Object(){
            @Override
            public String toString() {
                return "Data";
            }
        };
        HashMap map=new HashMap();
        Reference reference=null;
        System.out.println("Testing PhantomReference");

        reference=new PhantomReference(o,queue);
        map.put(reference,d);
        System.out.println(reference.get());
        System.out.println(map.get(reference));
        System.out.println(reference.isEnqueued());

        System.gc();
    }

    public static void t2(){
        ReferenceQueue queue=new ReferenceQueue();
        String s=new String("Hello World.");
        WeakReference wr=new WeakReference(s,queue);
        Thread t=new Thread(){
            @Override
            public void run() {
                try {
                    Reference reference= queue.remove();
                    System.out.println(reference+" event fired.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t.setDaemon(true);
        t.start();
        System.out.println("Reference Queue is listening.");
        s=null;
        System.out.println("Ready to GC.");
        System.gc();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("wr.get="+wr.get());
    }

    public static void main(String[] args) {
        Bootstrap.t2();
        ConnectionImpl impl;
    }

}
