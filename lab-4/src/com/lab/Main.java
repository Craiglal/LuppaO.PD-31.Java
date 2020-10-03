package com.lab;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        //Task 1
        int[] arr = {5, 3, 2, 8, 1, 4};
        arr = Sorter.sortArrayOnlyOdds(arr);
        System.out.println("____________");
        //Task 2
        int[] unique = {2, 2, 1, 1, 2, 2, 5};
        int result = Sorter.findUnique(unique);
        System.out.println(result);
    }
}

class Sorter {
    public static int[] sortArrayOnlyOdds(int[] arr){
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

    public static int findUnique(int[] inputArray)
    {
        int result = 0;
        for(int i=0;i<inputArray.length;i++)
        {
            result ^= inputArray[i];
        }

        return (result > 0 ? result : -1);
    }
}
