package cn.com.time.jdk.nio.selector;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.*;
import java.util.Set;

public class SelectorTest {

    /**
     * 单线程中操作多通道
     * @throws IOException
     */
    public static void t1() throws IOException {
        ServerSocketChannel channel=ServerSocketChannel.open();
        channel.configureBlocking(false);
        Selector selector=Selector.open();
        SelectionKey key=channel.register(selector,SelectionKey.OP_ACCEPT);
        while (true){
            int k=selector.select();
            if (k==0){
                continue;
            }
            Set<SelectionKey> keys=selector.selectedKeys();
            while (keys.iterator().hasNext()){
                SelectionKey kk=keys.iterator().next();
                keys.iterator().remove();
            }
        }
    }

}
