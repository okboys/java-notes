package cn.com.time.jdk.nio.netty;

import cn.com.time.jdk.nio.netty.example.DiscardServer;

public class Bootstrap {

    public static void main(String[] args) throws InterruptedException {
        int post;
        new DiscardServer(8080).run();
    }

}
