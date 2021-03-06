package com.designpatterns.singleton;

/**
 * 静态内部类（将对象的实现放到一个静态的内粗类里）
 * 加载的时候 静态内部类不会加载
 * jvm保证线程安全
 */
public class Mgr07 {
    private Mgr07(){}

    private static class Mgr07Holder{
        private final static Mgr07 INSTANCE = new Mgr07();
    }

    public static Mgr07 getInstance(){
        return Mgr07Holder.INSTANCE;
    }

    public static void main(String[] args){
        for(int i=0; i<100; i++){
            new Thread(() ->
                    System.out.println(Mgr07.getInstance().hashCode())
            ).start();
        }
    }
}
