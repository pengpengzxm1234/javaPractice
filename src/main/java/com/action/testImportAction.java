package com.action;

import com.service.ITestImplmentService;
import com.service.impl.TestImplServiceImpl;
import com.service.impl.TestImplementServiveImpl;

public class testImportAction {
    public static void main(String[] args){
        ITestImplmentService iTestImplmentService = new TestImplementServiveImpl();
        ITestImplmentService iTestImplmentService1 = new TestImplServiceImpl();
        System.out.println(iTestImplmentService.method());
        System.out.println(iTestImplmentService1.method());
    }
}
