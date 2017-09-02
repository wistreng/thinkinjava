package com.collection;

public class MyLinkedList<E> {

    private int size;
    private Node<E> first;
    private Node<E> last;


    /**
     * Returns the element at the specified position in this list.
     * @param index
     * @return
     */
    public E get(int index) {
        checkElementIndex(index);
        return node(index).item;
    }

    /**
     * Replaces the element at the specified position in this list with the
     * specified element.
     * @param index
     * @param element
     */
    public void set(int index, E element) {
        checkElementIndex(index);
        Node<E> x = node(index);
        x.item = element;
    }

    /**
     * Links e as last element.
     * @param e
     */
     private void linkLast(E e) {
        Node<E> x = last;
        Node<E> newNode = new Node<>(x,e,null);
        last = newNode;
        if(x == null) {
            first = newNode;
        }
        else{
            x.next = newNode;
        }
        size++;
    }

    /**
     * Inserts element e before target Node.
     * @param e
     * @param target
     */
    public void linkBefore(E e, Node<E> target) {
        Node<E> x = target.prev;
        Node<E> newNode = new Node<>(x,e,target);
        target.prev = newNode;
        if(x == null)
            first = newNode;
        else
            x.next = newNode;
        size++;
    }

    /**
     * Appends the specified element to the end of this list
     * @param e
     * @return
     */
    public boolean add(E e){
        linkLast(e);
        return true;
    }

    /**
     * Inserts the specified element at the specified position in this list.
     * Shifts the element currently at that position (if any) and any
     * subsequent elements to the right (adds one to their indices).
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        checkElementIndex(index);
        if(index == size)
            linkLast(e);
        else
            linkBefore(e, node(index));
    }

    /**
     * Returns the (non-null) Node at the specified element index.
     * @param index
     * @return Node
     */
    Node<E> node(int index) {
        Node<E> x = first;
        for(int i=0; i<index; i++){
            x = x.next;
        }
        return x;
    }


    public void checkElementIndex(int index){
        if(index <= 0 || index > size){
            throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
        }
    }

    public int size(){
        return size;
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E item, Node<E> next){
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

    public void print(){
        for(int i=0; i<size; i++){
            if(i==0)
                System.out.print(node(i).item);
            System.out.print("<-->"+node(i).item);
        }
    }
}
