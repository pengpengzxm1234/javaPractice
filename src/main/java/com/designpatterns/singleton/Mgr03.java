package com.designpatterns.singleton;

/**
 * lazy loading
 * 懒汉模式
 * 虽然达到了按需初始化的目的，但带来了线程安全问题
 * 同一个类的不同对象的hash码不同
 *
 */
public class Mgr03 {
    private static Mgr03 INSTANCE = null;

    private Mgr03(){}
    public static Mgr03 getInstance(){
        if(INSTANCE == null){
          /*  try{
                Thread.sleep(10);
            }catch (Exception e){
                e.printStackTrace();
            }*/
            INSTANCE = new Mgr03();
        }
        return INSTANCE;
    }

    public void m(){
        System.out.println("m");
    }

    public static void main(String[] args){
        for(int i=0; i<100; i++){
            new Thread(() ->
                System.out.println(Mgr03.getInstance().hashCode())
            ).start();
        }
    }
}
