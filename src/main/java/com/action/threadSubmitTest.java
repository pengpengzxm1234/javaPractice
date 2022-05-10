package com.action;

import io.netty.handler.codec.redis.ArrayRedisMessage;
import io.netty.util.concurrent.DefaultThreadFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class threadSubmitTest {
    public static ThreadPoolExecutor executor = new ThreadPoolExecutor(2,
            10, 10, TimeUnit.MINUTES, new LinkedBlockingQueue<>(10),
            new DefaultThreadFactory("test-thread-submit"), new ThreadPoolExecutor.CallerRunsPolicy());

    public void testSubmit() throws ExecutionException, InterruptedException {
        List<Integer> list = new ArrayList<>();
        Long start = System.currentTimeMillis();
        List<Future> futures = new ArrayList<>();
        for(int i = 0; i< 100; i++){
            final int nums = i;
            futures.add(executor.submit(()->{
                //System.out.println( Thread.currentThread().getName()+ " : "+nums);
                Thread.sleep(10);
                return nums + 1;
            }));
        }
        System.out.println("spend1:" + (System.currentTimeMillis() - start));
        futures.forEach(future -> {
            try {
                future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
        start = System.currentTimeMillis();
        List<Integer> list1 = new ArrayList<>();
        for(int i = 0; i< 100; i++){
            //System.out.println( Thread.currentThread().getName()+ " : "+i + 1);
            Thread.sleep(10);
            list1.add(i + 1);
        }
        System.out.println("spend:" + (System.currentTimeMillis() - start));
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        threadSubmitTest test = new threadSubmitTest();
        test.testSubmit();
    }
}
