package com.main.singletonmode;

/**
 * 懒汉模式线程安全写法（内部静态类）
 * @author pengpeng
 * @date 2018/1/4 下午6:06
 * @desc
 */
public class SingletonInnerClass {
    private static class LazyHolder{
        private static final SingletonInnerClass INSTANCE = new SingletonInnerClass();
    }

    private SingletonInnerClass(){

    }

    public static SingletonInnerClass getInstance(){
       return LazyHolder.INSTANCE;
    }

}
