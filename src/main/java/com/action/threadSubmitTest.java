package com.action;

import io.netty.handler.codec.redis.ArrayRedisMessage;
import io.netty.util.concurrent.DefaultThreadFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class threadSubmitTest {
    public static ThreadPoolExecutor executor = new ThreadPoolExecutor(2,
            10, 10, TimeUnit.MINUTES, new LinkedBlockingQueue<>(10),
            new DefaultThreadFactory("test-thread-submit"), new ThreadPoolExecutor.CallerRunsPolicy());

    public void testSubmit() throws ExecutionException, InterruptedException {
        List<Integer> list = new ArrayList<>();
        Long start = System.currentTimeMillis();
        for(int i = 0; i< 100000; i++){
            final int nums = i;
            Integer num =  executor.submit(()->{
                //System.out.println( Thread.currentThread().getName()+ " : "+nums);
                return nums + 1;
            }).get();
            list.add(num);
        }
        System.out.println("spend:" + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        List<Integer> list1 = new ArrayList<>();
        for(int i = 0; i< 100000; i++){
            list1.add(i + 1);
        }
        System.out.println("spend:" + (System.currentTimeMillis() - start));
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        threadSubmitTest test = new threadSubmitTest();
        test.testSubmit();
    }
}
