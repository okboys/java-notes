package cn.com.time.jdk.thread.join;

public class CentralThread implements Runnable{

    private Thread centralThread;

    public CentralThread(Thread centralThread){
        this.centralThread=centralThread;
    }

    @Override
    public void run() {
        try {
            System.out.println("CentralThread start");
            centralThread.join();
            System.out.println("Central thread joined");

            System.out.println("CentralThread executing");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
