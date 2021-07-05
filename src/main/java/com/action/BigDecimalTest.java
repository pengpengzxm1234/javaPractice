package com.action;

import java.math.BigDecimal;

public class BigDecimalTest {

    public void caculation(){
        Long end = 120L;
        Long now = 100L;
        Long extendTime = 10L;
        Integer expire = BigDecimal.valueOf(end).subtract(BigDecimal.valueOf(now)).add(new BigDecimal(extendTime)).intValue();
        System.out.println(expire);
    }

    public static void main(String[] args) {
        BigDecimalTest test = new BigDecimalTest();
        test.caculation();
    }
}
