package cn.com.time.jdk.thread.join;

public class JoinTest{

    public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(new JoinedThread());
        Thread t2=new Thread(new CentralThread(t1));

        t1.start();
        t2.start();

        System.out.println("Thread ended");
        t2.join();
    }

}
