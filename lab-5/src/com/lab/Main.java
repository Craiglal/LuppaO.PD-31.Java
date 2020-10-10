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

        boolean run = true;
        while(run){
            System.out.println("Choose option:");
            System.out.println("1) Input new value");
            System.out.println("2) Output the row");
            System.out.println("0) Exit");
            String choice = in.nextLine();
            switch (Integer.parseInt(choice)){
                case 1:
                    String value = in.nextLine();
                    if(value.contains("+")){
                        value = value.replace("+", "");
                        RowNames.AddToRow(value);
                    }
                    else if(value.contains("-")){
                        value = value.replace("-", "");
                        RowNames.RemoveFromRow(value);
                    }
                    break;
                case 2:
                    RowNames.ShowRow();
                    break;
                case 0:
                    run = false;
                    break;
                default:
                    break;
            }
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

class RowNames{
    static String row = "";

    public static void AddToRow(String value){
        row += value + " ";
    }

    public static void RemoveFromRow(String value){
        if(row.contains(value)){
            row = row.replace(value, "").trim();
        }
        else{
            System.out.println("No such value to remove");
        }
    }

    public static void ShowRow(){
        System.out.println(row.trim());
    }
}