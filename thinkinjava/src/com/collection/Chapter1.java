package com.collection;

import org.junit.Test;

import java.util.*;

public class Chapter1 {
    private List linkedList = new LinkedList();
    private List arrayList = new ArrayList();
    private List vector = new Vector();
    //LinkedList 底层实现为链表，查询慢，插入，修改，删除快，线程不安全，效率高。
    //Array 底层实现为数组，查询快，插入，修改，删除慢，线程不安全，效率高。
    //Vector 线程安全，效率低。

    @Test
    public void testMyArrayList(){
        //自己实现ArrayList 数组容量 自动扩容测试 容量为2
        MyArrayList list = new MyArrayList();
        list.add("aaa");
        list.add("aaa");
        list.add("aaa");
        list.add("aaa");
        list.add("aaa");
        System.out.println(list.elementData.length);

        list.remove(3);
        System.out.println(list.size());

        list.set(2,"bbb");
        list.set(2,"bbb");
        list.set(2,"bbb");
        list.set(2,"bbb");
        System.out.println(list.elementData.length);

        print(list);
    }

    public void print(MyArrayList list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println("---"+list.get(i));
        }
    }

    @Test
    public void testLinkedList() {
        LinkedList<String> list = new LinkedList<String>();
        if(list.add("aaa")){

            System.out.println(list.size());
        }
    }

    @Test
    public void testMyLinkedList() {
        MyLinkedList<String> list = new MyLinkedList<String>();
        list.add("aaa");
        list.add("aaa");
        list.add("aaa");
        list.add("aaa");
        list.add("aaa");
        System.out.println(list.size());

        list.add(3,"bbb");
        list.add(3,"bbb");
        list.add(3,"bbb");
        System.out.println(list.size());
        list.print();
    }
}
