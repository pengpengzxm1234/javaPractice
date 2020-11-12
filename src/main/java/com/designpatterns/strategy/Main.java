package com.designpatterns.strategy;

import java.util.Arrays;

/**
 *一步一步完成策略模式
 * 1、有一个具体的策略接口 comparator，这个comparator有很多具体的实现
 * 2、sort 使用comparator
 * 3、不改变sort方法，只需要添加新的策略方法
 * @Desc 封装不同的策略实现方法
 *
 * @函数石接口 @FunctionalInterface 注解 如果只有一个方法，可以不用注解
 */
public class Main {
    public static void main(String[] args){
        Cat[] a = {new Cat(1,1), new Cat(3,3), new Cat(5, 5)};
        Sorter<Cat> catSorter = new Sorter<>();
        catSorter.sort(a, new CatHeightComparator());
        System.out.println(Arrays.toString(a));
        catSorter.sort(a, new CatWeightComparator());
        System.out.println(Arrays.toString(a));

       /* Sorter<Dog> sorter = new Sorter();
        Dog[] dogs = {new Dog(1), new Dog(4), new Dog(7), new Dog(2)};
        sorter.sort(dogs, new DogComparator());
        System.out.println(Arrays.toString(dogs));*/
    }
}
