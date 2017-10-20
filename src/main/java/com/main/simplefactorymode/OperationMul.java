package com.main.simplefactorymode;

/**
 * Created by px on 2017/7/1.
 */
public class OperationMul extends Operation {
    private double numberA = 0;
    private double numberB = 0;

    public double getResult(){
        double result = 0;
        result = numberA * numberB;
        return result;
    }

    @Override
    public double getNumberA() {
        return numberA;
    }

    @Override
    public void setNumberA(double numberA) {
        this.numberA = numberA;
    }

    @Override
    public double getNumberB() {
        return numberB;
    }

    @Override
    public void setNumberB(double numberB) {
        this.numberB = numberB;
    }
}
