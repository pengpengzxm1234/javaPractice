package com.main.singletonmode;

/**
 * 双重检查锁定(懒汉模式——线程安全写法)
 * @author pengpeng
 * @date 2018/1/4 下午5:54
 * @desc
 */
public class SinglentonDoubleCheck {
    private static SinglentonDoubleCheck instance = null;

    private SinglentonDoubleCheck(){

    }

    public static SinglentonDoubleCheck getInstance(){
        if(null == instance) {
            synchronized (SinglentonDoubleCheck.class) {
                if (null == instance) {
                    instance = new SinglentonDoubleCheck();
                }
            }
        }
        return instance;
    }
}
