package com.action;

import java.util.Date;

public class ParamPassTest {

    public void testParamPass(){
        Date d1 = new Date("1 Apr 98");
        nextDayUpdate(d1);
        System.out.println("d1 after next day: " + d1);

        Date d2 = new Date("1 Apr 98");
        nextDayReplace(d2);
        System.out.println("d2 after next day:" + d2);
    }

    public void nextDayUpdate(Date arg){
        arg.setDate(arg.getDate() + 1);
        System.out.println("arg in next day :" + arg);
    }

    public void nextDayReplace(Date arg){
        arg = new Date(arg.getYear(), arg.getMonth(), arg.getDate() + 1);
        System.out.println("arg in next day:" + arg);
    }

    public static void main(String[] args) {
        ParamPassTest test = new ParamPassTest();
        test.testParamPass();
    }

}
