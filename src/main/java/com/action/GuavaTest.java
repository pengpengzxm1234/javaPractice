package com.action;

import java.util.concurrent.TimeUnit;

import org.springframework.cache.guava.GuavaCache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;

/**
 * @author yourname <yourname@baijiahulian.com>
 * Created on 2022-12-24
 */
public class GuavaTest {

    public void testGuavaPutExpire() throws InterruptedException {
        CacheBuilder builder = CacheBuilder.newBuilder()
                .expireAfterWrite(1000, TimeUnit.MILLISECONDS)
                .maximumSize(2000)
                .removalListener(new RemovalListener<Object, Object>() {
                    @Override
                    public void onRemoval(RemovalNotification<Object, Object> notification) {
                        System.out.println(notification.getKey()+ "remove cause:" + notification.getCause());
                    }
                })
                .recordStats();
        Cache<String, String> cache = builder.build();
        cache.put("key1", "value1");
        while (true){
            Thread.sleep(100);
            System.out.println(cache.getIfPresent("key1"));
        }
    }

    public static void main(String[] args) throws InterruptedException {
        GuavaTest guavaTest = new GuavaTest();
        guavaTest.testGuavaPutExpire();
    }
}
