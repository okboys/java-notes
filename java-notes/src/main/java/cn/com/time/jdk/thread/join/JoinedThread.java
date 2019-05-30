package cn.com.time.jdk.thread.join;

public class JoinedThread implements Runnable{
    @Override
    public void run() {
        System.out.println("JoinedThread executing");
    }
}
