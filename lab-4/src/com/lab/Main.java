package com.lab;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 8, 1, 4};
        arr = Sorter.sortArray(arr);
    }
}

class Sorter {
    public static int[] sortArray(int[] arr){
        ArrayList<Integer> odd = new ArrayList<Integer>();
        for(int i = 0; i < arr.length; i++){
            if(arr[i] % 2 == 1){
                odd.add(arr[i]);
            }
        }

        Collections.sort(odd);

        int count = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] % 2 == 1){
                arr[i] = odd.get(count++);
            }
        }

        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
        return arr;
    }
}
