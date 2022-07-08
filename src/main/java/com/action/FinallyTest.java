package com.action;

/**
 * @author yourname <yourname@baijiahulian.com>
 * Created on 2022-07-08
 */
public class FinallyTest {

    public static void main(String[] args) {
        int a = 12;
        try {
            if(a == 12){
                System.out.println("a返回了");
                return;
            }
            System.out.println("try 执行了");
        }finally {
            System.out.println("finally执行了");
        }
    }
}
