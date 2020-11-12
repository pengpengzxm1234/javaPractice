package com.designpatterns.abstractfactory;

import com.designpatterns.factory.CarFactory;
import com.designpatterns.factory.Moveable;

/**
 * 任意定制交通工具 继承Moveable
 * 任意定制生产过程 Moveable XXFactory.create
 * a 工厂方法：产品维度扩展，不同的产品对应不同的工厂
 * b 抽象工厂：产品一族进行扩展，某一个工厂从一个抽象工行继承
 *
 * 抽象方法：现实具体存在，不指定具体事物，需要抽象（名词）
 * 接口：某一个东西的属性 比如（形容词）可以干什么
 *
 */
public class Main {
    public static void main(String[] args){
        AbstractFactory factory = new ModernFactory();
        Food food = factory.createFood();
        Vericle vericle = factory.createVericle();
        Weapon weapon = factory.createWeapon();
    }
}
