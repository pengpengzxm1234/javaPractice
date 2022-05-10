package com.action;


import com.google.common.base.Throwables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExceptionTest {
    private Logger logger = LoggerFactory.getLogger(ExceptionTest.class);
    class User{
        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    public void testException(){
        try {
            User user = null;
            System.out.println(user.getAge());
        }catch (Exception e){
            //System.out.println(Throwables.getStackTraceAsString(e));
            //e.printStackTrace();
            //logger.info("error" +e);
            //logger.info("error: {}", Throwables.getStackTraceAsString(e));
            logger.info("error: {}", e);
        }
    }


    public static void main(String[] args) {
        ExceptionTest test = new ExceptionTest();
        test.testException();
    }
}
