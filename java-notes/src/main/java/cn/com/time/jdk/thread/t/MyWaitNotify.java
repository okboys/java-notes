package cn.com.time.jdk.thread.t;

/**
 * Created by TimaNetworks on 2017/8/22.
 */
public class MyWaitNotify {

    MonitorObject object=new MonitorObject();

    private boolean wasSingalled=false;

    public void doWait(){
        synchronized (object){

        }
    }

    /**
     * 自旋锁
     */
    public void wait1(){
        synchronized (object){
            while (!wasSingalled){
                //wait
            }
            wasSingalled=false;
        }
    }

}
