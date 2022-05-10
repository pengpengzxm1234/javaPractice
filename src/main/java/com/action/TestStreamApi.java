package com.action;

import java.beans.PersistenceDelegate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * java 8 stream api 练习
 */
public class TestStreamApi {

    public class Person{
        private Integer age;
        private String name;
        private String country;
        private char sex;

        public Person(Integer age, String name, String country, char sex) {
            this.age = age;
            this.name = name;
            this.country = country;
            this.sex = sex;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public char getSex() {
            return sex;
        }

        public void setSex(char sex) {
            this.sex = sex;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    ", country='" + country + '\'' +
                    ", sex=" + sex +
                    '}';
        }
    }

    public void testStreamFilter(){
        List<Person> list = new ArrayList<>();
        list.add(new Person(19, "zhangsan", "中国", 'M'));
        list.add(new Person(18, "王麻子", "中国", 'M'));
        list.add(new Person(20, "花花", "中国", 'F'));
        list.add(new Person(21, "lisa", "美国", 'F'));
        list.add(new Person(18, "tom", "美国", 'M'));
        list.add(new Person(21, "cate", "法国", 'M'));

        list.stream().filter(person -> person.age > 19).forEach(System.out::println);

        System.out.println("--------------------------------------------------------");
        long count = list.stream().filter(person -> person.getCountry().equals("中国")).count();
        System.out.println( count + " 中国人");

        System.out.println("--------------------------------------------------------");
        list.stream().map(person -> person.getCountry()).distinct().collect(Collectors.toList()).forEach(System.out::println);
    }

    public void testNull(){
        List<Person> list = null;
        list.stream().map(Person::getAge).collect(Collectors.toList());
    }


    public static void main(String[] args){
        TestStreamApi testStreamApi = new TestStreamApi();
        //testStreamApi.testStreamFilter();
        testStreamApi.testNull();
    }
}
