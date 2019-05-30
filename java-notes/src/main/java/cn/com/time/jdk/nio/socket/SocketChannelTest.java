package cn.com.time.jdk.nio.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

public class SocketChannelTest {

    public static void t1() throws IOException {
        SocketChannel channel=SocketChannel.open();
        channel.configureBlocking(false);//异步模式
        channel.connect(new InetSocketAddress("http://www.baidu.com",80));
        while (!channel.finishConnect()){
            //
        }
    }

}
