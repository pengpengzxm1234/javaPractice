package com.algorithm.linkedTest;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;


/**
 * 单向链表
 * create by pengpeng
 */
public class SingleLinked {
    private Node node;

    public SingleLinked(Node node){
        this.node = node;
    }

    public SingleLinked(){}

    /**
     * 在链表末尾添加节点
     * @param data
     */
    public void insert(Node data){
        if(null == this.node){
            node = new Node();
            node = data;
            return;
        }
        if(null == this.node.getNext()){
            node.setNext(data);
            return;
        }
        Node lastNode = getLastNode();
        lastNode.setNext(data);
    }

    /**
     * 将节点插入到置顶位置
     * @param index
     * @param data
     */
    public void insert(int index, Node data){
        Node preNode = this.node;
        //找到要插入的index前一个节点,并从前一个节点处分离成两个链表
        while ((index - 1) != preNode.getIndex()){
            preNode = preNode.getNext();
        }
        Node afterNode = preNode.getNext();//index后面的链表
        //插入index位置
        data.setIndex(index);
        preNode.setNext(data);
        //将后面的链表节点更新index插入到新的链表
        while (null != afterNode){
            afterNode.setIndex(afterNode.getIndex() + 1);
            Node newNode = Node.builder()
                    .index(afterNode.getIndex())
                    .name(afterNode.getName())
                    .build();
            preNode = preNode.getNext();
            preNode.setNext(newNode);
            afterNode = afterNode.getNext();
        }
    }

    /**
     * 获取指定位置的节点
     * @param index
     * @return
     */
    public Node getNode(int index){
        Node node = this.node;
        while (index != node.getIndex()){
            node = node.getNext();
        }
        return node;
    }

    /**
     * 获取第一个节点
     * @return
     */
    public Node first(){
        return this.node;
    }

    /**
     * 获取最后一个节点
     * @return
     */
    public Node last(){
        return this.getLastNode();
    }

    /**
     * 获取下一个节点
     */
    public Node next(){
        Node node = this.node;
        if(null != node.getNext()){
            Node next = node.getNext();
            return next;
        }
        return null;
    }

    /**
     * 删除第index个元素
     * @return
     */
    public void delete(int index){
        Node node = this.node;
        while ((index - 1) != node.getIndex()){
            node = node.getNext();
        }
        node.setNext(node.getNext().getNext());
    }

    /**
     * 遍历所有节点
     * @return
     */
    public String readNodes(){
        if(null == this.node){
            return null;
        }
        return JSONArray.toJSONString(this.node);
    }

    private Node getLastNode(){
        if(null == this.node){
            return null;
        }
        Node node = this.node;
        while (null != node.getNext()){
            node = node.getNext();
        }
        return node;
    }



    public static void main(String[] args){
        SingleLinked singleLinked = new SingleLinked();
        for(int i=0; i < 4; i++){
            Node node = Node.builder().name("name" + i).index(i).build();
            singleLinked.insert(node);
        }
        Node node = Node.builder().name("newName").index(2).next(null).build();
        singleLinked.insert(2,node);
        System.out.println(singleLinked.readNodes());

    }
}
