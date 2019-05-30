package cn.com.time.jdk.thread.forkjoin;

import java.util.concurrent.RecursiveTask;

public class CountRecursiveTask extends RecursiveTask<Integer>{

    int a[];

    int left;

    int right;

    public CountRecursiveTask(int[] a,int left,int right){
        this.a=a;
        this.left=left;
        this.right=right;
    }

    @Override
    protected Integer compute() {
        int count=0;
        if((right-left)<=50){
            for(int i=right;i<left;i++){
                count+=a[i];
            }

        }

        int middle=(left+right)/2;
        System.out.println("middle="+middle+" right="+right+" left="+left);
        CountRecursiveTask l=new CountRecursiveTask(a,left,middle);
        CountRecursiveTask r=new CountRecursiveTask(a,middle,right);

        l.fork();
        r.fork();
        return l.join()+r.join();
    }
}
