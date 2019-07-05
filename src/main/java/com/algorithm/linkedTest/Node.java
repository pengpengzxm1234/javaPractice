package com.algorithm.linkedTest;

import com.alibaba.fastjson.JSONObject;

public class Node {
    private String name;
    private int index;
    private Node next;

    public static Node.Builder builder(){
        return new Builder();
    }

    public Node(){}

    public Node(Builder builder){
        this.name = builder.name;
        this.index = builder.index;
        this.next = builder.next;
    }

    /**
     * set get buile
     * @param
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }


    public static class Builder{
       private String name;
       private int index;
       private Node next;

       public Builder name(String name){
           this.name = name;
           return this;
       }

       public Builder index(int index){
           this.index = index;
           return this;
       }

       public Builder next(Node next){
           this.next = next;
           return this;
       }

       public Node build(){
           return new Node(this);
       }
    }

    public static void main(String[] srgs){
        Node node =  Node.builder().index(1).name("2").build();
        System.out.println(JSONObject.toJSONString(node));
    }


}
