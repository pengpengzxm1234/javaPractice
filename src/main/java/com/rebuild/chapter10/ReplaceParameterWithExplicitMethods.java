package com.rebuild.chapter10;

import com.sun.org.apache.xml.internal.security.algorithms.SignatureAlgorithmSpi;
import io.netty.util.concurrent.DefaultThreadFactory;

import javax.crypto.ExemptionMechanism;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 10.6 已明确函数取代参数
 */
public class ReplaceParameterWithExplicitMethods{
    public static ThreadPoolExecutor executor = new ThreadPoolExecutor(2,
            10, 10, TimeUnit.MINUTES, new LinkedBlockingQueue<>(10),
            new DefaultThreadFactory("test-thread-submit"), new ThreadPoolExecutor.CallerRunsPolicy());
    public static class Employee{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        //step1
        public static Employee create(int type) throws IllegalAccessException {
            switch (type){
                case ENGINEER:
                    return new Engineer();
                case SALESMAN:
                    return new Salesman();
                case MANAGER:
                    return new Manager();
                default:
                    throw new IllegalAccessException("Incorrect type code value");
            }
        }
        //step2
        public static Employee newCreate(int type) throws IllegalAccessException {
            switch (type){
                case ENGINEER:
                    return Employee.createEngineer();
                case SALESMAN:
                    return Employee.createSalesman();
                case MANAGER:
                    return Employee.createManager();
                default:
                    throw new IllegalAccessException("Incorrect type code value");
            }
        }

        //final
        public static Employee createEngineer(){
            return new Engineer();
        }

        public static Employee createSalesman(){
            return new Salesman();
        }

        public static Employee createManager(){
            return new Manager();
        }
    }
    public static class Engineer extends Employee{

    }

    public static class Salesman extends Employee{

    }

    public static class Manager extends Employee{

    }


    static final int ENGINEER = 1;
    static final int SALESMAN = 2;
    static final int MANAGER = 3;


    public static void doSomething(Employee employee){
        return;
    }

    public static void main(String[] args) throws Exception{
        //old
        Employee kent1 = Employee.create(ENGINEER);
        //replace
        Employee kent = Employee.createEngineer();
        executor.submit(()->{
            kent.setName("lisi");
            doSomething(kent);
        });

    }



}
