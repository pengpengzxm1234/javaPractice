package com.main.singletonmode;

/**
 * 单利模式（饿汉模式）
 * 类加载后就实例化instance对象
 * @author pengpeng
 * @date 2018/1/4 下午5:51
 * @desc
 */
public class SingletonEHanMode {
    private static SingletonEHanMode instance = new SingletonEHanMode();

    private SingletonEHanMode(){}

    public static SingletonEHanMode getInstance(){
        return instance;
    }
}
