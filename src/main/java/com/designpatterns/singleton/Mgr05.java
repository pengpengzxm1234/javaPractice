package com.designpatterns.singleton;

/**
 * 效率低 加锁
 * 线程不安全
 */
public class Mgr05 {
    private static Mgr05 INSTANCE = null;

    private Mgr05(){}
    public static  Mgr05 getInstance(){
        if(INSTANCE == null){
            synchronized(Mgr05.class){
                try{
                    Thread.sleep(10);
                }catch (Exception e){
                    e.printStackTrace();
                }
                INSTANCE = new Mgr05();
            }
        }
        return INSTANCE;
    }

    public void m(){
        System.out.println("m");
    }

    public static void main(String[] args){
        for(int i=0; i<100; i++){
            new Thread(() ->
                    System.out.println(Mgr05.getInstance().hashCode())
            ).start();
        }
    }
}
