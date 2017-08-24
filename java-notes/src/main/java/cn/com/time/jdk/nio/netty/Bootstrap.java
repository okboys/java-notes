package cn.com.time.jdk.nio.netty;

import cn.com.time.jdk.nio.netty.example.DiscardServer;

/**
 * Created by TimaNetworks on 2017/8/22.
 */
public class Bootstrap {

    public static void main(String[] args) throws InterruptedException {
        int post;
        new DiscardServer(8080).run();
    }

}
