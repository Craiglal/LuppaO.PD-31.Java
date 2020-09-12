package com.lab;

public class Main {

    public static void main(String[] args) {
        int[][] arrayDouble = ArrayWorker.FillArrayWithRandom(7,2);

        ArrayWorker.PrintArray(arrayDouble);
        System.out.println();
        ArrayWorker.PrintArrayDiagonalEvens(arrayDouble);
        System.out.println();

        int[] array = ArrayWorker.FillArrayWithStep(0, 16, 3);

        ArrayWorker.PrintArray(array);
    }
}


class ArrayWorker{
    public static int[][] FillArrayWithRandom(int N, int M){
        int[][] array = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                array[i][j] = (int) (Math.random() * 9);
            }
        }
        return array;
    }

    public static void PrintArray(int array[][]){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void PrintArray(int array[]){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void PrintArrayDiagonalEvens(int array[][]){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if(i ==j){
                    if(array[i][j] % 2 == 0){
                        System.out.println(array[i][j]);
                    }
                }
            }
        }
    }

    public static int[] FillArrayWithStep(int begin, int end, int step){
        int array[] = new int[(int)Math.ceil((end - begin) / (double)step)];

        for(int i = 0; i < array.length; i++){
            array[i] = begin;
            begin += step;
        }

        return  array;
    }
}