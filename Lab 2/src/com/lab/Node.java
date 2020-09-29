package com.lab;

public class Node {
    private int data;
    public Node next;

    public Node(int _data){
        data = _data;
        next = null;
    }

    public int get(){
        return data;
    }
}
