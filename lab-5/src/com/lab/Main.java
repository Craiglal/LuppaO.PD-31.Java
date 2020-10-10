package com.lab;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        System.out.println(Lab5.CalculateString(input));

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
}