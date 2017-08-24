package cn.com.time.jdk.thread.t;

/**
 * Created by TimaNetworks on 2017/8/22.
 */
public class ThreadTest extends Thread{

    @Override
    public void run() {
        System.out.println("Hello Runnable...");
    }

    /**
     * 线程之间的通信(通过共享对象通信)
     */

    public static void t1(){
        MySingal singal=new MySingal();
        while (!singal.hasDataToProcess){
            //......
        }
    }

}
