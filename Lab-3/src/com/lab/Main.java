package com.lab;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        List<String> mylist = Arrays.asList("a1", "a2", "b1", "b2", "c2", "c1", "c3");
        mylist.sort(Comparator.naturalOrder());
        for (int i = 0; i < mylist.size(); i++){
            if(mylist.get(i).contains("c")){
                System.out.println(mylist.get(i).toUpperCase());
            }
        }
        System.out.println();

        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        input.close();

        int[] arr = new int[N];
        for (int i = 0; i < arr.length; i++){
            arr[i] = (int)(Math.random() * (0 - 9 + 1) + 9);
        }
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        double sum = 0;
        int counter = 0;
        for (int i = 0; i < arr.length; i++){
            if(arr[i] % 2 == 0){
                sum += arr[i];
                counter++;
            }
        }

        System.out.println("Avg = " + sum / counter);
        System.out.println();

        String str = "sjdhgfsjkavchjwagehf";
        Pattern pattern = Pattern.compile("[h-tH-T]", Pattern.CASE_INSENSITIVE);
        String result = "";
        for (int i = 0; i < str.length(); i++){
            Matcher matcher = pattern.matcher(str.substring(i,i + 1));
            if(matcher.find()){
                result += str.substring(i,i + 1).toUpperCase();
            }
            else{
                result += str.substring(i,i + 1);
            }
        }
        System.out.println(result);
        System.out.println();
    }
}
