package com.thread;


import java.util.concurrent.Callable;

/**
 * 手写Future
 */
public class FutureTest {
    public interface Future<T>{
        T get() throws InterruptedException;
        boolean isDone();
        void cancle();
        boolean isCancle();
    }

    public static class FutureTask<T> implements Future<T>{

        private volatile boolean done = false;
        private boolean cancel = false;
        private T result;

        @Override
        public T get() throws InterruptedException {
            synchronized (this){
                while (!done){
                    this.wait();
                }
                return result;
            }
        }

        protected void done(T result){
            synchronized (this){
                this.result = result;
                this.done = true;
                notifyAll();
            }
        }


        @Override
        public boolean isDone() {
            return done;
        }

        @Override
        public void cancle() {

        }

        @Override
        public boolean isCancle() {
            return cancel;
        }
    }

    public static class FutureService<T>{

        public Future submit(Callable<T> callable){
            final FutureTask task = new FutureTask();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    T result = null;
                    try {
                        result = callable.call();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    task.done(result);
                }
            }).start();
            return task;
        }

    }

    public static void main(String[] args) throws InterruptedException {
        FutureService futureService = new FutureService();
        Future future = futureService.submit(new Callable() {
            @Override
            public String call() throws Exception {
                System.out.println("call start");
                Thread.sleep(1000);
                return "call end";
            }
        });
        Thread.sleep(1000);
        System.out.println("Thread main do other things");

        System.out.println(future.isDone());
        System.out.println(future.get());

    }
}
