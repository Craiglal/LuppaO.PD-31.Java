package com.lab;

public class Stack {
    private Node head;
    private int length;

    public Stack(){
        head = null;
        length = 0;
    }

    public Stack(int data){
        head = new Node(data);
        length = 1;
    }

    public int size(){
        return length;
    }

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        length++;
    }

    public int pop() throws Exception {
        if (head == null)
            throw new Exception("There are no elements");
        int result = head.get();
        head = head.next;
        length--;
        return result;
    }

    public boolean contains(int data){
        Node elem = head;
        while(elem != null){
            if (elem.get() == data)
                return true;
            elem = elem.next;
        }
        return false;
    }
}
