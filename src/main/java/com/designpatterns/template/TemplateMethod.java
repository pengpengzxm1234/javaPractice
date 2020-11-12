package com.designpatterns.template;

/**
 * 设计模式——模板方法模式（钩子函数、回调函数）
 *
 */
public class TemplateMethod {

    public static void main(String[] args){
        F f = new C1();
        f.m();
    }

}

/**
 * 模板 抽象类，里面提供一系列抽象方法
 */
abstract class F{
    void m(){
        op1();
        op2();
    }

    abstract void op1();
    abstract void op2();
}

/**
 * 实际类，继承模板，实现抽象方法
 */
class C1 extends F{

    @Override
    void op1() {
        System.out.println("op1");
    }

    @Override
    void op2() {
        System.out.println("op2");
    }
}
