package cn.com.time.jdk.nio.filechannel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * FileChannel例子
 */
public class FileChannelTest {

    /**
     * 通道读数据
     * @throws IOException
     */
    public void t1() throws IOException {
        RandomAccessFile file=new RandomAccessFile("D:\\NIO测试\\a.txt","rw");
        FileChannel channel=file.getChannel();
        ByteBuffer buf=ByteBuffer.allocate(1024);
        int n=channel.read(buf);
        while (n!=-1){
            //offset回执到起始位置
            buf.flip();
            while (buf.hasRemaining()){
                System.out.println((char)buf.get());
            }
            buf.clear();
            n=channel.read(buf);
        }
        file.close();
    }

    /**
     * 通道之间的信息传输
     */
    public void t2() throws IOException {
        RandomAccessFile fromeFile=new RandomAccessFile("D:\\NIO测试\\a.txt","rw");
        FileChannel fromeChannel=fromeFile.getChannel();
        RandomAccessFile toFile=new RandomAccessFile("D:\\NIO测试\\a.txt","rw");
        FileChannel toChannel=fromeFile.getChannel();
        long position=0;
        long count=fromeChannel.size();
//        toChannel.transferFrom(fromeChannel,position,count);
        fromeChannel.transferTo(position,count,toChannel);
    }

    public void t3() throws FileNotFoundException {
        RandomAccessFile file=new RandomAccessFile("","");
        FileChannel channel=file.getChannel();
//        channel.force();
//        channel.position()
//        channel.position(1)
//        channel.truncate()
//        channel.size()
    }

}
