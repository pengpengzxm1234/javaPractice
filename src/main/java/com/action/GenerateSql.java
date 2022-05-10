package com.action;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * @author yourname <yourname@baijiahulian.com>
 * Created on 2022-05-11
 */
public class GenerateSql {

    public static String generateSql() {
        StringBuilder builder = new StringBuilder(
                "insert into s1 (key1,key2,key3,key_part1, key_part2, key_part3, common_field) values");
        char[] arr = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r',
                's','t','u','v', 'w', 'x', 'y', 'z'};
        for(int i = 1000; i< 10000; i++){
            String insert = String.format("('%s',%d,'%s','%s', '%s', '%s', '%s'),", arr[RandomUtils.nextInt(0,26)],i,
                    arr[RandomUtils.nextInt(0,26)],arr[RandomUtils.nextInt(0,26)],arr[RandomUtils.nextInt(0,26)],
                    arr[RandomUtils.nextInt(0,26)],arr[RandomUtils.nextInt(0,26)]);
            builder.append(insert);
        }
        return builder.toString();
    }

    public static String generateSql1() {
        StringBuilder builder = new StringBuilder(
                "insert into s4 (key1,key3,key_part1, key_part2, key_part3, common_field) values");
        char[] arr = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r',
                's','t','u','v', 'w', 'x', 'y', 'z'};
        for(int i = 1000; i< 10000; i++){
            char value = arr[RandomUtils.nextInt(0,26)];
            String insert = String.format("('%s','%s','%s', '%s', '%s', '%s'),", value,
                    value,value,value, value,value);
            builder.append(insert);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(generateSql1());
    }
}
