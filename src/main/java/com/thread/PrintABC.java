package com.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 三个线程顺序打印abc
 */
public class PrintABC {
    static Lock lock = new ReentrantLock();
    static int cnt = 0;



    public static void main(String[] args) throws InterruptedException {
        Thread thd1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0;i<10;){
                    try {
                        lock.lock();
                        if(cnt % 3 == 0){
                            System.out.println("A");
                            cnt++;
                            i++;
                        }
                        lock.unlock();
                    }catch (Exception e){

                    }
                }

            }
        });

        Thread thd2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0;i<10;){
                    try {
                        lock.lock();
                        if(cnt % 3 == 1){
                            System.out.println("B");
                            cnt++;
                            i++;
                        }
                        lock.unlock();
                    }catch (Exception e){

                    }
                }
            }
        });

        Thread thd3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0;i<10;){
                    try {
                        lock.lock();
                        if(cnt % 3 == 2){
                            System.out.println("C");
                            cnt++;
                            i++;
                        }
                        lock.unlock();
                    }catch (Exception e){

                    }
                }
            }
        });

        thd1.start();
        thd2.start();
        thd3.start();

        Thread.sleep(10000L);


    }
}
