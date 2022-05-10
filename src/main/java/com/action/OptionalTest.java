package com.action;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * java8 optional 练习
 */
public class OptionalTest {

    public class Address {
        private String city;
        private String country;

        public Address(String city, String country) {
            this.city = city;
            this.country = country;
        }

        public Address() {
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        @Override
        public String toString() {
            return "Address{" +
                    "city='" + city + '\'' +
                    ", country='" + country + '\'' +
                    '}';
        }
    }

    public class User {
        private String name;
        private Integer age;
        private Address address;


        public User(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public User() {
        }

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

        public Address getAddress() {
            return address;
        }

        public void setAddress(Address address) {
            this.address = address;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public Address setAddress(String city, String country) {
        Address address = new Address(city, country);
        return address;
    }

    public User setUser(String name, Integer age) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        return user;
    }

    public void simpleOptional(User user) {
        Optional<User> opt = Optional.ofNullable(user)
                .filter(user1 -> user.getAge() > 10);
        System.out.println(user.getName() + " " + opt.isPresent());
    }

    public void simpleNull(User user) {
        user = Optional.ofNullable(user)
                .filter(user1 -> user1.getAge() > 10)
                .orElse(new User(user.getName(), 12));
        System.out.println(user.toString());
    }

    public String simpleMap(User user) {
        return Optional.ofNullable(user)
                .map(u -> u.getAddress())
                .map(a -> a.getCountry())
                .orElseThrow(() -> new RuntimeException("错误了"));
    }

    public void simpleList(List<User> userList) {
        System.out.println(Optional.ofNullable(userList).isPresent());
        Optional.ofNullable(userList)
                .ifPresent(users -> users.forEach(u -> System.out.println(u.toString())));
    }


    public void testElstThrow(){
        // 没钱就会抛异常
        try {
            System.out.println(Optional.ofNullable("").orElseThrow(()->new Exception()));  // 没钱抛异常
        } catch (Throwable throwable) {
            System.out.println("没有钱");
            throwable.printStackTrace();
        }
    }


    public void testEmpty(){
        Optional optional = Optional.empty();
        System.out.println("optional:"+optional.isPresent());
    }

    public static void main(String[] args) {

        OptionalTest test = new OptionalTest();
        OptionalTest.User user = test.setUser("zhangsan", 10);
        user.setAddress(test.setAddress("city", "zhongguo"));
        test.simpleOptional(user);
        test.simpleNull(user);
        System.out.println(" map =======" + test.simpleMap(user));
        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(test.setUser("lisi", 13));
        test.simpleList(null);
        test.testElstThrow();
        test.testEmpty();
    }

}
