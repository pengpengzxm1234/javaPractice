package com.thread;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock
 */
public class Aqs_ReentrantLock {
    private ReentrantLock reentrantLock = new ReentrantLock();

    public void method1(){
        try {
            reentrantLock.lock();
            System.out.println("线程" + Thread.currentThread().getName() + " m1 is get lock");
            method2();
        }catch (Exception e){

        }finally {
            System.out.println("线程" + Thread.currentThread().getName() + " " + reentrantLock.getHoldCount());
            reentrantLock.unlock();
            System.out.println("线程" + Thread.currentThread().getName() + " " + reentrantLock.getHoldCount());
        }
    }

    public void method2(){
        try {
            reentrantLock.lock();
            System.out.println("线程" + Thread.currentThread().getName() +" m2 is get lock " + reentrantLock.getHoldCount());
        }catch (Exception e){

        }finally {
            if(reentrantLock.isLocked()){
                System.out.println("线程" + Thread.currentThread().getName() + " " + reentrantLock.getHoldCount());
                reentrantLock.unlock();
                System.out.println("线程" + Thread.currentThread().getName() + " " + reentrantLock.getHoldCount());
            }
        }
    }

    public static void main(String[] args){
        Aqs_ReentrantLock aqs_reentrantLock = new Aqs_ReentrantLock();

        new Thread(new Runnable() {
            @Override
            public void run() {
                aqs_reentrantLock.method1();
            }
        }, "t1").start();

        try {
            TimeUnit.SECONDS.sleep(1L);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        new Thread(aqs_reentrantLock :: method2, "t2").start();

    }
}
