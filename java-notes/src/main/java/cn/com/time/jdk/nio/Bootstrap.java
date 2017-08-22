package cn.com.time.jdk.nio;

import cn.com.time.jdk.nio.filechannel.FileChannelTest;

import java.io.IOException;

/**
 * Created by TimaNetworks on 2017/8/21.
 */
public class Bootstrap {

    public static void main(String[] args) throws IOException {
        FileChannelTest t=new FileChannelTest();
        t.t1();
    }

}

