package com.lab;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<String> mylist = Arrays.asList("a1", "a2", "b1", "b2", "c2", "c1", "c3");
        Task.sortList(mylist);

        Task.avgArray(10);

        String str = "sjdhgfsjkavchjwagehf";
        Task.stringSort(str);
    }
}
//todo streams
class Task{
    public static void sortList(List<String> mylist){
        mylist.stream().filter(s -> s.startsWith("c")).sorted().forEach(s -> System.out.println(s.toUpperCase()));
    }

    public static void avgArray(int N){
        Integer[] arr = new Integer[N];
        List<Integer> nums = Arrays.asList(arr);
        Random random = new Random();
        System.out.println(nums.stream().mapToInt(i -> random.nextInt(10)).filter(i -> i % 2 == 0).average()
                .getAsDouble());
    }

    public static void stringSort(String str){
        str = Pattern.compile("").splitAsStream(str)
                .map(s -> (s.charAt(0) >= 'h' && s.charAt(0) <= 't') ? s.toUpperCase(): s).collect(Collectors.joining());
        System.out.println(str);
    }
}
