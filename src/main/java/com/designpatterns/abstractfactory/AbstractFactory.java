package com.designpatterns.abstractfactory;

/**
 * 抽象的工厂，生产抽象的产品
 */
public abstract class AbstractFactory {
    abstract Food createFood();
    abstract Vericle createVericle();
    abstract Weapon createWeapon();

}
