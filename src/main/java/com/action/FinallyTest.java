package com.action;

import org.apache.commons.lang3.math.NumberUtils;

/**
 * @author yourname <yourname@baijiahulian.com>
 * Created on 2022-07-08
 */
public class FinallyTest {

    public static void main(String[] args) {
        long a = 0;
        try {
            if(a == NumberUtils.LONG_ZERO){
                System.out.println("a返回了");
                return;
            }
            System.out.println("try 执行了");
        }finally {
            System.out.println("finally执行了");
        }
    }
}
