package cn.com.time.jdk.thread;


import cn.com.time.jdk.thread.concurrent.ConcurrentTest;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.TimeoutException;

/**
 * Created by TimaNetworks on 2017/8/22.
 */
public class Bootstrap {

    public static void main(String[] args) throws InterruptedException, BrokenBarrierException, TimeoutException {
        ConcurrentTest.t16();
    }

}
