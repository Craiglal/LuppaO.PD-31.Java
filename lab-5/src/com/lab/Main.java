package com.lab;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        System.out.println(Lab5.CalculateString(input));

        String number = in.nextLine();
        int[] arr = Lab5.FillInArrayN(Integer.parseInt(number));

        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}

class Lab5{
    public static double CalculateString(String input){
        String operators[]=input.split("[0-9]+");
        String operands[]=input.split("[+-/*//]");

        double result = Double.parseDouble(operands[0]);
        for(int i=1;i<operands.length;i++){
            if(operators[i].equals("+"))
                result += Integer.parseInt(operands[i]);
            else if(operators[i].equals("*"))
                result *= Integer.parseInt(operands[i]);
            else if(operators[i].equals("/"))
                result /= Integer.parseInt(operands[i]);
            else
                result -= Integer.parseInt(operands[i]);
        }
        return result;
    }

    public static int[] FillInArrayN(int N){
        int[] arr = new int[N];

        int middle = (int) Math.ceil((double)N / 2) - 1;
        arr[middle] = 0;

        int left = middle-1;
        int right = middle+1;

        for(int i = 1; i < (N % 2 == 0 ? middle+2: middle+1); i++){
            if(i < middle+1)
                arr[left--] = i;
            arr[right++] = i;
        }
        return arr;
    }
}