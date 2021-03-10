package com.thread;

/**
 * 无线循环创建线程 不start
 */
public class CreateThreadNoStart {

    public static void createThread(){
        for(;;){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {

                }
            });
        }
    }

    public static void main(String[] args){
        createThread();
    }
}
