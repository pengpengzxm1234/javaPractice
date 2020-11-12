package com.designpatterns.factory;

/**
 * 任意定制交通工具 继承Moveable
 * 任意定制生产过程 Moveable XXFactory.create()
 */
public class Main {
    public static void main(String[] args){
        Moveable c = new CarFactory().create();
        c.go();
    }
}
