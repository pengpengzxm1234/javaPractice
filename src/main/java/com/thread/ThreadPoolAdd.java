package com.thread;

import com.spring.A;
import io.netty.util.concurrent.DefaultThreadFactory;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 使用线程池做累加操作保证原子性
 */
public class ThreadPoolAdd {
    static ThreadPoolExecutor executor = new ThreadPoolExecutor(2,
            10,
            2,
            TimeUnit.SECONDS,
            new LinkedBlockingDeque<>(),
            new DefaultThreadFactory("add"),
            new ThreadPoolExecutor.AbortPolicy());


    public static void add(int nums) throws InterruptedException {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        for(int i = 1; i<= nums;i++){
            final int num = i;
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(atomicInteger.getAndAdd(num));
                }
            });
        }
        Thread.sleep(10000L);
        System.out.println(atomicInteger.get());
    }

    public static void main(String[] args)throws Exception{
        add(10);
    }

}
