package com.main.simplefactorymode;

/**
 * 简单工厂模式
 * Created by px on 2017/7/1.
 */
public class SimpleFactoryMode {

    public static Operation createOperate(String operate){
        Operation oper = null;
        switch (operate){
            case "*":
                oper = new OperationMul();
                break;
            case "/":
                oper = new OperationDiv();
                break;
            default:
                break;
        }
        return oper;
    }
}
