package cn.com.time.jdk.thread.sp;

import java.util.Vector;

public class Consumer implements Runnable{

    private Vector<String> contents;

    public Consumer(Vector<String> contents){
        this.contents=contents;
    }

    @Override
    public void run() {
        synchronized (contents){
            while (true){
                if(contents.size()==0){
                    try {
                        System.out.println("Thread "+Thread.currentThread().getName()+" consume");
                        contents.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    String content=contents.lastElement();
                    contents.remove(content);
                    System.out.println("Thread "+Thread.currentThread().getName()+" Consumers consume a message. "+
                            "Content is :"+content+". length is "+contents.size());
                    //消费完毕进入阻塞，等待其他线程消费或者生产
                    contents.notifyAll();
                    try {
                        contents.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
