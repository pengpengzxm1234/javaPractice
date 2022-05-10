package com.action;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class JSONTest {

    static class User{
        String name;
        Integer age;
        Integer sex;
        String firstName;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public Integer getSex() {
            return sex;
        }

        public void setSex(Integer sex) {
            this.sex = sex;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }
    }


    public void testJSONToObject(){
        JSONObject object = new JSONObject();
        object.put("name", "lisi");
        object.put("address", "lis");
        object.put("age", 1);
        object.put("love", "love");
        User user = JSONObject.parseObject(object.toJSONString(), User.class);
        System.out.println(JSONObject.toJSONString(user));
    }

    public void JSONToString(){
        User user = new User();
        user.setAge(11);
        user.setName("haha");
        user.setSex(1);
        user.setFirstName("lili");
        User user1 = new User();
        user1.setAge(11);
        user1.setName("jja");
        user1.setSex(1);
        user1.setFirstName("kks");
        List<User> list = new ArrayList<>();
        list.add(user);
        list.add(user1);

        String json = JSON.toJSONString(list);
        System.out.println(json);
    }

    public static void main(String[] args) {
        JSONTest test = new JSONTest();
        //test.testJSONToObject();
        test.JSONToString();
    }
}
