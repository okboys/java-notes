package cn.com.time.jdk.thread.concurrent;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created on 202017/9/28 16:17 By tong.luo
 * <p>
 * Copyright @ 2017 Tima Networks Inc. All Rights Reserved. 
 */
public class ConcurrentTest {

    /**
     * ArrayBlockingQueue
     */
    public static void t1(){
        BlockingQueue queue=new ArrayBlockingQueue(1024);
        Producer producer=new Producer(queue);
        Consumer consumer=new Consumer(queue);
        new Thread(producer).start();
        new Thread(consumer).start();
    }

    /**
     * DelayQueue
     */
    public static void t2() throws InterruptedException {
        DelayQueue queue=new DelayQueue();
        Delayed element=new Delayed() {
            @Override
            public long getDelay(TimeUnit unit) {

                return 0;
            }

            @Override
            public int compareTo(Delayed o) {
                return -1;
            }
        };
        queue.add(element);
        Object o=queue.take();
        System.out.println(o);
    }

    /**
     * LinkedBlockingQueue
     */
    public static void t3() throws InterruptedException {
        BlockingQueue<String> queue=new LinkedBlockingDeque<>();
        queue.put("123");
        queue.take();
    }

    /**
     * LinkedBlockingQueue
     */
    public static void t4() throws InterruptedException {
        BlockingQueue<String> queue=new PriorityBlockingQueue<>();
        queue.put("123");
        queue.take();
    }

    /**
     * SynchronousQueue同步队列，队列中存在元素时，如果试图向一个队列中插入一个新的元素，将阻塞
     */

    /**
     * BlockingDeque
     */
    public static void t5(){
        BlockingDeque blockingDeque=new LinkedBlockingDeque();
        blockingDeque.addFirst(1);
        blockingDeque.addLast(2);
    }

    /**
     * ConcurrentMap
     */
    public static void t6(){
        ConcurrentMap map=new ConcurrentHashMap();
        map.put("a","b");
        Object o= map.get("a");
    }

    /**
     * CountDownLatch 闭锁
     */
    public static void t7(){
        CountDownLatch countDownLatch=new CountDownLatch(3);
        Waiter waiter=new Waiter(countDownLatch);
        Decrementer decrementer=new Decrementer(countDownLatch);
        new Thread(waiter).start();
        new Thread(decrementer).start();
    }

    /**
     * CyclicBarrier
     */
    public static void t8() throws BrokenBarrierException, InterruptedException, TimeoutException {
        CyclicBarrier barrier1=new CyclicBarrier(2, new Runnable() {
            @Override
            public void run() {
                System.out.println("barrier1 executed.");
            }
        });
        CyclicBarrier barrier2=new CyclicBarrier(2, new Runnable() {
            @Override
            public void run() {
                System.out.println("barrier2 executed.");
            }
        });

        CyclicBarrierRunnable c1=new CyclicBarrierRunnable(barrier1,barrier2);
        CyclicBarrierRunnable c2=new CyclicBarrierRunnable(barrier1,barrier2);
        new Thread(c1).start();
        new Thread(c2).start();
    }

    /**
     * Exchanger
     */
    public static void t9(){
        Exchanger exchanger=new Exchanger();
        String A="a";
        String B="b";
        ExchangeRunnable r1=new ExchangeRunnable(A,exchanger);
        ExchangeRunnable r2=new ExchangeRunnable(B,exchanger);
        new Thread(r1).start();
        new Thread(r2).start();
    }

    /**
     * Semaphore:用于线程之间的协作
     */
    public static void t10() throws InterruptedException {
        Semaphore semaphore=new Semaphore(1);
        //获得信号
        semaphore.acquire();
        //释放信号
        semaphore.release();
    }

    /**
     * ExecutorService:执行器服务
     */
    public static void t11() throws ExecutionException, InterruptedException {
        ExecutorService executorService=Executors.newFixedThreadPool(10);
        //线程执行Runnable
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("Asynchronous task");
            }
        });
        Future<String> future=executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "a";
            }
        });
        Set<Callable<String>> callables = new HashSet<Callable<String>>();

        callables.add(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "a";
            }
        });

        callables.add(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "b";
            }
        });

        callables.add(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "c";
            }
        });

        callables.add(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "d";
            }
        });

        /**
         * 返回任一一个callback的执行结果
         */
        String result=executorService.invokeAny(callables);

        List<Future<String>> futures=executorService.invokeAll(callables);

        /**
         * ExecutorService的关闭
         */
        executorService.shutdown();//不再接收新的任务，所有任务执行完毕后关闭
        executorService.shutdownNow();//立即关闭
    }

    /**
     * ThreadPoolExecutor:线程池执行者
     */
    public static void t12(){
        int corePoolSize=5;
        int maxPoolSize=10;
        long keepAliveTime=10000;
        ExecutorService executorService=new ThreadPoolExecutor(
                corePoolSize,
                maxPoolSize,
                keepAliveTime,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<Runnable>()
        );
    }

    /**
     * ScheduledExecutorService:定时执行者服务
     */
    public static void t13(){
        ScheduledExecutorService executor=Executors.newScheduledThreadPool(10);
        executor.schedule(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "called!";
            }
        },5,TimeUnit.SECONDS);
    }

    /**
     * ForkJoinPool:进行分叉与合并
     */
    public static void t14(){
        ForkJoinPool forkJoinPool=new ForkJoinPool(4);
        RecursiveAction action=new MyRecursiveAction(100);
        forkJoinPool.invoke(action);
    }

    /**
     * Lock
     */
    public static void t15(){
        Lock lock=new ReentrantLock();
        lock.lock();
        System.out.println("locked!");
        lock.unlock();
    }

    /**
     * ReadWriteLock 读写锁
     */
    public static void t16(){
        ReadWriteLock lock=new ReentrantReadWriteLock();
        lock.readLock().lock();
        System.out.println("readwritelock!");
        lock.readLock().unlock();
    }

    /**
     * Atomic
     */
    public static void t17(){
        AtomicBoolean bool=new AtomicBoolean(true);
        boolean v=bool.get();
        boolean expect=bool.compareAndSet(false,false);
    }

    /**
     * AtomicReference:原子引用类型
     */
    public static void t18(){
        String str="Hello world!";
        AtomicReference<String> reference=new AtomicReference<>(str);
        String s=reference.get();
    }

    /**
     * fork and join
     */
    public static void t19() throws InterruptedException {
        Thread t=new Thread(new TestJoin());
        long start=System.currentTimeMillis();
        t.start();
        t.join(100);
        System.out.println(System.currentTimeMillis()-start);
        System.out.println("Main finished!");
    }

    /**
     * wait and notify,notifyall
     */
    public static void t20(){

        Queue queue=new PriorityQueue();
        new IComsumer("打印机",queue,10).start();
        new IProducer("电脑",queue,10).start();

    }
}

/**
 * 生产者
 */
class Producer implements Runnable{

    private BlockingQueue queue;

    public Producer(BlockingQueue queue){
        this.queue=queue;
    }

    @Override
    public void run() {
        try {
            queue.put(1);
            Thread.sleep(1000);
            queue.put(2);
            Thread.sleep(1000);
            queue.put(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 消费者
 */
class Consumer implements Runnable{

    private BlockingQueue queue;

    public Consumer(BlockingQueue queue){
        this.queue=queue;
    }

    @Override
    public void run() {
        try {
            System.out.println(queue.take());
            System.out.println(queue.take());
            System.out.println(queue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

/**
 * 服务员
 */
class Waiter implements Runnable{

    private CountDownLatch countDownLatch;

    public Waiter(CountDownLatch countDownLatch){
        this.countDownLatch=countDownLatch;
    }

    @Override
    public void run() {
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Waiter released.");
    }

}

/**
 * 减幅器
 */
class Decrementer implements Runnable{

    private CountDownLatch countDownLatch;

    public Decrementer(CountDownLatch countDownLatch){
        this.countDownLatch=countDownLatch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            countDownLatch.countDown();
            Thread.sleep(1000);
            countDownLatch.countDown();
            Thread.sleep(1000);
            countDownLatch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class CyclicBarrierRunnable implements Runnable{

    private CyclicBarrier barrier1;

    private CyclicBarrier barrier2;

    public CyclicBarrierRunnable(CyclicBarrier b1,CyclicBarrier b2){
        this.barrier1=b1;
        this.barrier2=b2;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("Barrier1 wait at "+Thread.currentThread().getName());
            barrier1.await();
            Thread.sleep(1000);
            System.out.println("Barrier2 wait at "+Thread.currentThread().getName());
            barrier2.await();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

}

class ExchangeRunnable implements Runnable{

    private Object obj;

    private Exchanger exchanger;

    public ExchangeRunnable(Object obj,Exchanger exchanger){
        this.obj=obj;
        this.exchanger=exchanger;
    }

    @Override
    public void run() {
        try {
            System.out.println("Exchange = "+this.obj+" Thread ="+Thread.currentThread().getName());
            this.obj=exchanger.exchange(this.obj);
            System.out.println("Exchange = "+this.obj+" Thread = "+Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class MyRecursiveAction extends RecursiveAction{

    private long workLoad=0;

    public MyRecursiveAction(long workLoad){
        this.workLoad=workLoad;
    }

    @Override
    protected void compute() {
        if(this.workLoad>24){
            List<MyRecursiveAction> actions=new ArrayList<>();
            actions.addAll(createActions());
            actions.stream().forEach(m->{
                //拆分
                m.fork();
            });
        }else{
            System.out.println("Object = "+this+" Thread = "+Thread.currentThread().getName()+" Doing workLoad myself : "+this.workLoad);
        }
    }

    private List<MyRecursiveAction> createActions(){
        List<MyRecursiveAction> actions=new ArrayList<>();
        actions.add(new MyRecursiveAction(this.workLoad/2));
        actions.add(new MyRecursiveAction(this.workLoad/2));
        return actions;
    }

}

class TestJoin implements Runnable {

    @Override
    public void run() {
        for(int i=1;i<5;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("睡眠"+i);
        }
        System.out.println("TestJoin finished...");
    }

}

class IComsumer extends Thread{

    private String name;

    private Queue<Integer> queue;

    private int maxSize;

    public IComsumer(String name,Queue queue,int maxSize){
        super(name);
        this.queue=queue;
        this.maxSize=maxSize;
    }

    @Override
    public void run() {
        while (true){
            synchronized (queue){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                while (queue.isEmpty()){
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Integer i=queue.remove();
                System.out.println("NAME:"+getName()+" consume "+i);
                if(queue.isEmpty()){
                    System.out.println("queue is empty");
                    queue.notify();
                }
        }
        }
    }
}

class IProducer extends Thread{

    private String name;

    private Queue<Integer> queue;

    private int maxSize;

    public IProducer(String name,Queue queue,int maxSize){
        super(name);
        this.queue=queue;
        this.maxSize=maxSize;
    }

    @Override
    public void run() {
        int i=0;
        while (true){
            synchronized (queue){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //循环等待
                while (queue.size()==maxSize){
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                i++;
                queue.add(i);
                System.out.println("NAME:"+getName()+" produce "+i);
                if(queue.size()==maxSize){
                    System.out.println("queue is full");
                    queue.notify();
                }
            }
        }
    }
}