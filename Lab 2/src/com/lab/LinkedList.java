package com.lab;

public class LinkedList {
    private Node head;
    private int length;

    public LinkedList(){
        head = null;
        length = 0;
    }

    public int size(){
        return length;
    }

    public void add(int data){
        if (head == null){
            head = new Node(data);
        } else{
            Node node = head;
            while (node.next != null){
                node = node.next;
            }
            node.next = new Node(data);
        }
        length++;
    }

    public void remove(int item) {
        if (head != null){
            if (head.get() == item) {
                head = head.next;
            }
            else {
                Node elem = head;

                while (elem.next != null && elem.next.get() != item){
                    elem = elem.next;
                }

                if (elem.next != null){
                    elem.next = elem.next.next;
                }
                else {
                    System.out.println("No item in array");
                }
            }
            length--;
        } else{
            System.out.println("The array is empty");
        }
    }

    public boolean contains(int item){
        if (head != null){
            Node elem = head;
            while (elem.next != null){
                if (elem.get() == item){
                    return true;
                }
                elem = elem.next;
            }
        }
        return false;
    }
}
