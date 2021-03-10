package com.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 写一个死锁
 */
public class DeadLock {
    public static Lock lock1 = new ReentrantLock();
    public static Lock lock2 = new ReentrantLock();


    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                lock1.lock();
                System.out.println("Thread1 lock1 lock");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread1 wait lock2");
                lock2.lock();
                System.out.println("Thread1 lock2 lock");
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                lock2.lock();
                System.out.println("Thread2 lock2 lock");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread2 wait lock1");
                lock1.lock();
                System.out.println("Thread2 lock1 lock");
            }
        });

        thread1.start();
        thread2.start();

        Thread.sleep(10000);

    }


}
