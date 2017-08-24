package cn.com.time.jdk.thread.t;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 * Created by TimaNetworks on 2017/8/22.
 */
public class NioNonBlockingHttpClient {

    private static Selector selector;

    private Charset charset=Charset.forName("utf-8");

    static {
        try {
            selector=Selector.open();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void connect(SelectionKey key) throws IOException {

    }

}
