package com.rebuild.chapter10;

/**
 * 10。8 以函数取代参数
 */
public class ReplaceParameterWithMethods {
    int quantity;
    int itemPrice;
    public double getPrice(){
        int basePrice = quantity * itemPrice;
        int discountLevel;
        if(quantity > 100){
            discountLevel = 2;
        }else {
            discountLevel = 1;
        }
        double finalPrice = discountedPrice(basePrice, discountLevel);
        return finalPrice;
    }

    public double discountedPrice(int basePrice, int discountLevel){
        if(discountLevel == 2){
            return basePrice * 0.1;
        }else {
            return basePrice * 0.05;
        }
    }

    //优化后
    public double getPriceNew(){
        return discountPriceNew();
    }

    public double discountPriceNew(){
        if(getDiscountLevel() == 2){
            return getBasePrice() * 0.1;
        }else {
            return getBasePrice() * 0.05;
        }
    }

    private int getDiscountLevel(){
        if(quantity > 100){
            return 2;
        }else {
            return 1;
        }

    }

    private double getBasePrice(){
        return quantity * itemPrice;
    }

    //再优化 Inline method(内联函数)
    public double getPriceNew1(){
        if(getDiscountLevel() == 2){
            return getBasePrice() * 0.1;
        }else {
            return getBasePrice() * 0.05;
        }
    }
}
