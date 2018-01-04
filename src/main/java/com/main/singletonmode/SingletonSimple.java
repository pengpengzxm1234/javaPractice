package com.main.singletonmode;

/**
 * 简单单例模式（懒汉模式）
 * @author pengpeng
 * @date 2018/1/4 下午5:41
 * @desc
 */
public class SingletonSimple {
    private static SingletonSimple instance;

    //私有化构造方法，防止外界利用new创建一个单利模式的实例
    private SingletonSimple(){

    }

    public static SingletonSimple getInstance(){
        if(null == instance){
            instance = new SingletonSimple();
        }
        return instance;
    }
}
