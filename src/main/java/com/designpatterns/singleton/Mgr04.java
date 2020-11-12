package com.designpatterns.singleton;

/**
 * 效率低 加锁
 */
public class Mgr04 {
    private static Mgr04 INSTANCE = null;

    private Mgr04(){}
    public static synchronized Mgr04 getInstance(){
        if(INSTANCE == null){
            try{
                Thread.sleep(10);
            }catch (Exception e){
                e.printStackTrace();
            }
            INSTANCE = new Mgr04();
        }
        return INSTANCE;
    }

    public void m(){
        System.out.println("m");
    }

    public static void main(String[] args){
        for(int i=0; i<100; i++){
            new Thread(() ->
                    System.out.println(Mgr04.getInstance().hashCode())
            ).start();
        }
    }
}
