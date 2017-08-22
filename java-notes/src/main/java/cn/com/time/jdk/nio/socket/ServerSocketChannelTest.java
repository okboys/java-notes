package cn.com.time.jdk.nio.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by TimaNetworks on 2017/8/21.
 */
public class ServerSocketChannelTest {

    public void t1() throws IOException {
        ServerSocketChannel channel=ServerSocketChannel.open();
        channel.bind(new InetSocketAddress(9999));
        while (true){
            SocketChannel c=channel.accept();
            if(c!=null){
                //doSomething
            }
        }
    }

}
