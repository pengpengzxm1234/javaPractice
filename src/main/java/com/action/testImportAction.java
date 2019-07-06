package com.action;

import com.alibaba.fastjson.JSONArray;
import com.service.ITestImplmentService;
import com.service.impl.TestImplServiceImpl;
import com.service.impl.TestImplementServiveImpl;

import java.util.ArrayList;
import java.util.List;

public class testImportAction {
    public static void main(String[] args){
       /* ITestImplmentService iTestImplmentService = new TestImplementServiveImpl();
        ITestImplmentService iTestImplmentService1 = new TestImplServiceImpl();
        System.out.println(iTestImplmentService.method());
        System.out.println(iTestImplmentService1.method());*/
        List<String> list = new ArrayList<>();
        String data;
        for(int i=0; i<10; i++){
            data = String.valueOf(i);
            list.add(data);
        }
        System.out.println(JSONArray.toJSONString(list));
    }
}
