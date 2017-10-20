package com.service.impl;

import com.service.ITestImplmentService;

/**
 * Created by px on 2017/3/9.
 */
public class TestImplementServiveImpl implements ITestImplmentService {

    @Override
    public String method() {
        return "新继承的接口——新";
    }
}
