package com.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextTest {

    public static void main(String[] args){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        A a = (A)ac.getBean("a");
        System.out.println(a);
        a.a();
    }
}
