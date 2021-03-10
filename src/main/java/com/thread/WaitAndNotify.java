package com.thread;


public class WaitAndNotify {
    public static Object nameA = "A";
    public static Object nameB = "B";

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (nameA){
                    try {
                        System.out.println(Thread.currentThread() +  " task start");
                        nameA.wait();
                        System.out.println(Thread.currentThread() +  " task end");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (nameA){
                    System.out.println(Thread.currentThread() +  " task2 start");
                    nameA.notify();
                    System.out.println(Thread.currentThread() +  " task2 end");
                }
            }
        });
        thread1.start();
        thread2.start();

        Thread.sleep(10000);
    }
}
