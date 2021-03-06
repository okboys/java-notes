package cn.com.time.jdk.thread.sp;

import java.util.Vector;

public class Producer implements Runnable{

    private Vector<String> contents;

    public Producer(Vector<String> contents){
        this.contents=contents;
    }


    @Override
    public void run() {
        synchronized (contents){
            while (true){
                if(contents.size()==0){
                    String content="produce content";
                    contents.add(content);
                    System.out.println("Thread "+Thread.currentThread().getName()+" Producer produces a message. "+
                            "Content is :"+content+". length is "+contents.size());

                    contents.notifyAll();

                }else{
                    try {
                        System.out.println("Thread "+Thread.currentThread().getName()+" producer");
                        contents.notifyAll();
                        contents.wait();
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
