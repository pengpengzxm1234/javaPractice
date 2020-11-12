package com.designpatterns.singleton;

/**
 * 饿汉方式
 * 类加载到内存后就实例化一个单例，jvm保证线程安全
 * 简单实用，推荐使用
 * 唯一缺点，不管用到与否，类装载是就完成实例化
 * Class.forName("")
 */
public class Mgr01 {
    private static final Mgr01 INSTANCE = new Mgr01();

    private Mgr01(){}

    public Mgr01 getInstance(){
        return INSTANCE;
    }

    public static void main(String[] args){
        Mgr01 mgr01 = Mgr01.INSTANCE;
        Mgr01 mgr011 = Mgr01.INSTANCE;
        System.out.println(mgr01 == mgr011);
    }

}
