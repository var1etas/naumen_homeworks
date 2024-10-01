package com.study.naumen.homework2;

import java.util.Scanner;

public class Task1 {
    public void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int min = -1000;
        int max = 1000;
        for(int i = 0; i < n; i++){
            arr[i] = min + (int)(Math.random() * ((max - min) + 1));
        }
        System.out.println(minValue(arr));
    }

    public int minValue(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int num : arr) {
            if (Math.abs(num) < min) min = Math.abs(num);
        }
        return min;
    }
}
