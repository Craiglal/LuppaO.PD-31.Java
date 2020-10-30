package com.lab;

public class ArrayList {
    private int[] array;
    private int position;

    public ArrayList(){
        this(6);
    }

    public ArrayList(int capacity){
        //todo exeption
        if (capacity > 0){
            array = new int[capacity];
        }
        else {
            array = new int[6];
        }
        position = 0;
    }

    public int size() {
        return position;
    }

    public int getCapacity() {
        return array.length;
    }

    public void add(int item){
        if (getCapacity() == position){
            int[] newArray = new int[getCapacity() + 1];

            for (int i = 0; i < getCapacity(); i++){
                newArray[i] = array[i];
            }
            array = newArray;
        }
        array[position] = item;
        position++;
    }

    public void remove(int _position){
        if (position > _position && _position >= 0){
            for (int i = _position; i < position - 1; i++){
                array[i] = array[i + 1];
            }
            position--;
        }
        if (position + 8 < getCapacity() && getCapacity() > 16){
            int[] newArray = new int[getCapacity() - 8];
            for (int i = 0; i < position - 1; i++){
                newArray[i] = array[i];
            }
            array = newArray;
        }
    }

    public boolean contains(int item){
        int i = 0;
        while (i < position){
            if (array[i] == item)
                return true;
            i++;
        }
        return false;
    }
}
