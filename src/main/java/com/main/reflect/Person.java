package com.main.reflect;

import javax.swing.*;
import java.io.Serializable;

/**
 * @author pengpeng
 * @date 2018/1/5 下午4:19
 * @desc
 */
public class Person implements Serializable, TestInterface {
    private Long id;
    public String name;

    public Person(){
        this.id = 100L;
        this.name = "huahuagagalala";
    }

    public Person(Long id, String name){
        this.id = id;
        this.name = name;
    }

    public Person(Long id){
        this.id = id;
    }

    @SuppressWarnings("unused")
    private Person(String name){
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "Person [id=" + id + ", name=" + name + "]";
    }
    private String getSomeThing() {
        return "sdsadasdsasd";
    }

    private void testPrivate(){
        System.out.println("this is a private method");
    }
}
