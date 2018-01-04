package com.main.singletonmode;

/**
 * 懒汉模式（线程安全），在getInstance()上加锁
 * @author pengpeng
 * @date 2018/1/4 下午6:02
 * @desc
 */
public class Singleton {
    private static Singleton instance = null;

    private Singleton(){

    }

    public static synchronized Singleton getInstance(){
        if(null == instance){
            instance = new Singleton();
        }
        return instance;
    }
}
