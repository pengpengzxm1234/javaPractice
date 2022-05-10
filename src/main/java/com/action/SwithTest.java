package com.action;

/**
 * @author yourname <yourname@baijiahulian.com>
 * Created on 2021-09-04
 */
public class SwithTest {

    public static void main(String[] args) {
        int type =3;
        switch (type){
            case 1:
            case 2:
                System.out.println("1 or 2");
                break;
            case 3:
                System.out.println("3");
                break;
            default:
                break;
        }
    }
}
