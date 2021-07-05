package com.action;

import com.alibaba.fastjson.JSONObject;

public class JSONTest {

    static class User{
        String name;
        Integer age;
        Integer sex;

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

    public static void main(String[] args) {
        JSONTest test = new JSONTest();
        test.testJSONToObject();
    }
}
