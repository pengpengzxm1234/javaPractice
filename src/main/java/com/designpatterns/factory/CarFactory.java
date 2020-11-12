package com.designpatterns.factory;

public class CarFactory {
    public Moveable create(){
        System.out.println("car is created");
        return new Car();
    }
}
