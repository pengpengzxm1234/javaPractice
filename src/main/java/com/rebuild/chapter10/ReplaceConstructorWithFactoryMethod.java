package com.rebuild.chapter10;

/**
 * 10。12 共产函数取代构造函数
 */
public class ReplaceConstructorWithFactoryMethod {
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
        //step2 添加新的子类 不需要再去添加create函数
        public static Employee newCreate(int type) throws IllegalAccessException {
            switch (type){
                case ENGINEER:
                    return create("Engineer");
                case SALESMAN:
                    return create("Salesman");
                case MANAGER:
                    return create("Manager");
                default:
                    throw new IllegalAccessException("Incorrect type code value");
            }
        }
        
        public static Employee create(String name) throws IllegalAccessException {
            try {
                return (Employee) Class.forName(name).newInstance();
            }catch (Exception e){
                throw new IllegalAccessException("Unable to instantiate" + name);
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
    public static class Engineer extends Employee {

    }

    public static class Salesman extends Employee {

    }

    public static class Manager extends Employee {

    }


    static final int ENGINEER = 1;
    static final int SALESMAN = 2;
    static final int MANAGER = 3;
}
