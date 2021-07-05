package com.action;

import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class SetTest {

    public void treeSetTest(){
        Set<String> set = new TreeSet<>();
        set.add("a");
        set.add("c");
        set.add("a");
        set.add("d");
        set.add("b");
        System.out.println(set.toString());
    }

    public void treeSetTestInt(){
        TreeSet<Integer> set = new TreeSet<>();
        set.add(1);
        set.add(3);
        set.add(1);
        set.add(2);
        System.out.println(set.toString());
    }

    public void setToStrTest(){
        Set<Integer> set = new TreeSet<>();
        set.add(2);
        set.add(1);
        set.add(3);
        System.out.println(set.toString());
        String str =  StringUtils.join(set.iterator(), ",");
        System.out.println(str);
    }

    public static void main(String[] args) {
        SetTest test = new SetTest();
        test.treeSetTest();
        test.treeSetTestInt();
        test.setToStrTest();
    }
}
