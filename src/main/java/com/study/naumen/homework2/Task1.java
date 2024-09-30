package com.study.naumen.homework2;

public class Task1 {
    public static void main(String[] args) {
        int[] arr = new int[100];
        int min = -1000;
        int max = 1000;
        for(int i = 0; i < arr.length; i++){
            arr[i] = min + (int)(Math.random() * ((max - min) + 1));
        }
        System.out.println(minValue(arr));
    }

    public static int minValue(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int num : arr) {
            if (Math.abs(num) < min) min = Math.abs(num);
        }
        return min;
    }
}
