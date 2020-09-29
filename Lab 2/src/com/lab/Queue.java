package com.lab;

public class Queue {
    private Node start;
    private Node end;
    private int length;

    public Queue(){
        start = null;
        end = null;
        length = 0;
    }

    public Queue(int data){
        start = new Node(data);
        end = start;
        length = 1;
    }

    public int size() {
        return length;
    }

    public void queue(int data){
        if (start == null) {
            start = new Node(data);
            end = start;
        } else if (length == 1){
            end = new Node(data);
            start.next = end;
        } else {
            Node newNode = new Node(data);
            end.next = newNode;
            end = newNode;
        }
        length++;
    }

    public int dequeue(){
        int result = start.get();
        start = start.next;
        length--;
        return result;
    }

    public boolean contains(int data){
        Node elem = start;
        while(elem != null){
            if (elem.get() == data){
                return true;
            }
            elem = elem.next;
        }
        return false;
    }
}
