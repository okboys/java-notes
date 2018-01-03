//package cn.com.time.jdk.thread.forkjoin;
//
//import io.netty.util.internal.chmv8.ForkJoinPool;
//
//import java.util.Random;
//import java.util.concurrent.TimeUnit;
//
///**
// * Created on 2017/12/18 17:44
// *
// * @author: tong.luo
// * Copyright @2017 Tima Networks Inc. All Rights Reserved. 
// */
//public class Test {
//
//    public static final int SIZE=1000000;
//
//    public static void main(String[] args) throws InterruptedException {
//        Test.t3();
//
//    }
//
//    public static void t1() throws InterruptedException {
//        long start=System.currentTimeMillis();
//        ForkJoinPool pool=new ForkJoinPool();
//        int arr[] = generateArray();
//        pool.execute(new PrintRecursiveAction(arr,0,SIZE));
//        pool.awaitTermination(2, TimeUnit.SECONDS);
//        System.out.println("花费时间"+(System.currentTimeMillis()-start));
//    }
//
//    public static void t2(){
//        long start=System.currentTimeMillis();
//        int[] arr=generateArray();
//        for (int i=0;i<arr.length;i++){
//            System.out.println(arr[i]);
//        }
//        System.out.println("花费时间"+(System.currentTimeMillis()-start));
//    }
//
//    public static void t3() throws InterruptedException {
//        int[] arr=generateArray(100);
//        long start=System.currentTimeMillis();
//        ForkJoinPool pool=new ForkJoinPool();
//        pool.submit(new CountRecursiveTask(arr,0,SIZE));
//        System.out.println("花费时间"+(System.currentTimeMillis()-start));
//    }
//
//    public static int[] generateArray(){
//        Random random=new Random();
//        int[] arr=new int[SIZE];
//        for(int i=0;i<SIZE;i++){
//            arr[i]=random.nextInt(10000);
//        }
//
//        return arr;
//    }
//
//    public static int[] generateArray(int range){
//        Random random=new Random();
//        int[] arr=new int[SIZE];
//        for(int i=0;i<SIZE;i++){
//            arr[i]=random.nextInt(range);
//        }
//
//        return arr;
//    }
//}
