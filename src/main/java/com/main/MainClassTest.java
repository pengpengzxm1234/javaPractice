package com.main;

import com.service.ITestImplmentService;
import com.service.impl.TestImplServiceImpl;
import com.service.impl.TestImplementServiveImpl;

/**
 * Created by px on 2017/3/9.
 */
public class MainClassTest {
    public static void main(String[] args) {
        ITestImplmentService testImplmentService = new TestImplementServiveImpl();
        System.out.println(testImplmentService.method());
        ITestImplmentService testImplmentService1 = new TestImplServiceImpl();
        System.out.println(testImplmentService1.method());
    }
}
