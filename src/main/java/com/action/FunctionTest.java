package com.action;

import java.util.function.Supplier;

/**
 * @author yourname <yourname@baijiahulian.com>
 * Created on 2022-09-21
 */
public class FunctionTest {
    public void testSupplier(){
        Supplier supplier = () -> {System.out.println("执行了逻辑"); return "返回了结果";};
        System.out.println("下一步");
        System.out.println(supplier.get());
    }

    public static void main(String[] args) {
        FunctionTest functionTest = new FunctionTest();
        functionTest.testSupplier();
    }
}
