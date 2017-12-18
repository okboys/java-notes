package cn.com.time.jdk.thread.forkjoin;

import java.util.concurrent.RecursiveAction;

/**
 * Created on 2017/12/18 17:20
 *
 * @author: tong.luo
 * Copyright @2017 Tima Networks Inc. All Rights Reserved. 
 */
public class PrintRecursiveAction extends RecursiveAction{

    private int size=50;

    private int[]a;

    private int left;

    private int right;

    int count=0;

    public PrintRecursiveAction(int[]a,int left,int right){
        this.a=a;
        this.left=left;
        this.right=right;
    }

    @Override
    protected void compute() {
        if(right-left<=50){
            for (int i=left;i<right;i++){
                System.out.println(Thread.currentThread().getName()+" print :"+a[i]);
            }
        }else{
            int middle=(left+right)/2;
            PrintRecursiveAction l=new PrintRecursiveAction(a,left,middle);
            PrintRecursiveAction r=new PrintRecursiveAction(a,middle,right);

            l.fork();
            r.fork();
        }
    }

}
