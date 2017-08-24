package cn.com.time.jdk.thread.t;

/**
 * Created by TimaNetworks on 2017/8/22.
 */
public class MySingal {

    protected boolean hasDataToProcess=false;

    public synchronized boolean hasDataToProcess(){
        return this.hasDataToProcess;
    }

    public void setHasDataToProcess(boolean hasDataToProcess) {
        this.hasDataToProcess = hasDataToProcess;
    }
}
