package com.collection;


import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class MyArrayList /*implements*/ {
    //ArrayList的底层实现

    //ArrayList是基于数组实现
    public Object[] elementData;
    //数组的最小长度，在jdk中使用的是10
    private static final int MIN_CAPACITY = 2;

    private int size;

    public int size() {
        return this.size;
    }

    /*default Constructs*/
    public MyArrayList(){
        this(MIN_CAPACITY);
    }
    /*parameter Constructs*/
    public MyArrayList(int initialCapacity) {
        if(initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: "+
                    initialCapacity);
        }
        elementData = new Object[initialCapacity];
    }

    /*add method*/
    public void add(Object obj) {
        ensureCapacity(size);
        //插入新对象
        elementData[size++] = obj;
    }

    /*实现数组的扩容 右移运算符 等价于原容量乘以2*/
    public void ensureCapacity (int size) {
        if(size == elementData.length) {
            elementData = Arrays.copyOf(elementData, size << 1);
        }
    }

    /*get method*/
    public Object get(int index) {
        //rangeCheck
        rangeCheck(index);
        return elementData[index];
    }

    /*remove(index) method*/
    public void remove(int index) {
        rangeCheck(index);
        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(elementData, index+1, elementData, index,
                    numMoved);
        elementData[--size] = null;
    }
    /*remove(Object) method*/
    public void remove(Object obj) {
        for(int i=0; i<size; i++) {
            if(get(i).equals(obj)){
                remove(i);
            }
        }
    }

    public void set(int index, Object element) {
        rangeCheck(index);
        ensureCapacity(size+1);
        System.arraycopy(elementData, index, elementData,index +1, size-index+1);
        elementData[index] = element;
        size++;
    }


    /*rangeCheck method*/
    public void rangeCheck(int index) {
        if(index >= size) {
            throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
        }
    }
}
