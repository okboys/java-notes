package cn.com.time.jdk.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by TimaNetworks on 2017/8/24.
 */
public class ThreadPoolTest {

    public static void t1(){
        //cachedThreadPool
        ExecutorService service= Executors.newCachedThreadPool();
        for(int i=0;i<10;i++){

        }
    }

}
