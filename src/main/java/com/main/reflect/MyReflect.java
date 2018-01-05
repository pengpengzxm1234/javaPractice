package com.main.reflect;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;


/**
 * @author pengpeng
 * @date 2018/1/5 下午4:27
 * @desc
 */
public class MyReflect {
    public String className = null;

    @SuppressWarnings("rawtypes")
    public Class personClass = null;

    /**
     * 反射Person类
     * @throws Exception
     */
    @Before
    public void init()throws Exception{
        className = "com.main.reflect.Person";
        personClass = Class.forName(className);
    }

    /**
     *获取一个class文件的对象
     */
    @Test
    public void getClassName()throws Exception{
        System.out.println(personClass);
    }

    /**
     *获取某个class文件对象的另一种方式
     */
    @Test
    public void getClassName2()throws Exception{
        System.out.print(Person.class);
    }

    /**
     * 创建一个class文件表示的实例对象，底层会调用空参数的构造方法
     */
    @Test
    public void getNewInstance()throws Exception{
        System.out.println(personClass.newInstance());
    }

    /**
     * 获取非私有的构造函数
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    @Test
    public void getPublicConstructor()throws Exception{
        Constructor constructor = personClass.getConstructor(Long.class, String.class);
        Person person = (Person)constructor.newInstance(100L,"gaga");
        System.out.println(person.getId());
        System.out.println(person.getName());
    }

    /**
     * 获得私有的构造函数
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    @Test
    public void getPrivateConsturcto()throws Exception {
        Constructor constructor = personClass.getDeclaredConstructor(String.class);
        constructor.setAccessible(true);
        Person person = (Person)constructor.newInstance("guagua");
        System.out.println(person.getName());
    }

    /**
     * 访问非私有的成员变量
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    @Test
    public void getNoPrivateField()throws Exception{
        Constructor constructor = personClass.getConstructor(Long.class, String.class);
        Object obj = constructor.newInstance(100L, "guagua");

        Field field = personClass.getField("name");
        field.set(obj, "lisi");
        System.out.println(field.get(obj));

    }

    /**
     * 访问私有的成员变量
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    @Test
    public void getPrivateField()throws Exception{
        Constructor constructor = personClass.getConstructor(Long.class);
        Object obj = constructor.newInstance(100L);

        Field field = personClass.getDeclaredField("id");
        field.setAccessible(true);
        field.set(obj, 2000L);
        System.out.println(field.get(obj));

    }

    /**
     * 获取非私有的成员函数（方法）
     */
    @SuppressWarnings("unchecked")
    @Test
    public void getNoPrivateMethod()throws Exception{
        System.out.println(personClass.getMethod("toString"));

        Object obj = personClass.newInstance();//获取空参的构造函数
        Method toStringMethod = personClass.getMethod("toString");
        Object object = toStringMethod.invoke(obj);
        System.out.println(object);
    }

    /**
     * 获取私有的成员函数(方法)
     */
    @SuppressWarnings("unchecked")
    @Test
    public void getPrivateMethod() throws Exception {
        Object obj = personClass.newInstance();
        Method method = personClass.getDeclaredMethod("getSomeThing");
        method.setAccessible(true);
        Object value = method.invoke(obj);
        System.out.println(value);
    }

    /**
     *
     */
    @Test
    public void otherMethod() throws Exception {
        //当前加载这个class文件的那个类加载器对象
        System.out.println(personClass.getClassLoader());
        //获取某个类实现的所有接口
        Class[] interfaces = personClass.getInterfaces();
        for (Class class1 : interfaces) {
            System.out.println(class1);
        }
        //反射当前这个类的直接父类
        System.out.println(personClass.getGenericSuperclass());
        /**
         * getResourceAsStream这个方法可以获取到一个输入流，这个输入流会关联到name所表示的那个文件上。
         */
        //path 不以’/'开头时默认是从此类所在的包下取资源，以’/'开头则是从ClassPath根下获取。其只是通过path构造一个绝对路径，最终还是由ClassLoader获取资源。
        System.out.println(personClass.getResourceAsStream("/log4j.properties"));
        System.out.println(personClass.getResourceAsStream("log4j.properties"));

        //判断当前的Class对象表示是否是数组
        System.out.println(personClass.isArray());
        System.out.println(new String[3].getClass().isArray());

        //判断当前的Class对象表示是否是枚举类
        System.out.println(personClass.isEnum());
        System.out.println(Class.forName("cn.itcast_04_reflect.City").isEnum());

        //判断当前的Class对象表示是否是接口
        System.out.println(personClass.isInterface());
        System.out.println(Class.forName("cn.itcast_04_reflect.TestInterface").isInterface());


    }

}
