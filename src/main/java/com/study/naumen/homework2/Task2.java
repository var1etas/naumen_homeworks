package com.study.naumen.homework2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task2 {
    public void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Double> arr = new ArrayList<>();
        for(int i = 0; i < n; i++){
            arr.add(Math.random());
        }
        quickSort(arr,0, n-1);
        System.out.println(arr);
    }
    public void quickSort(List<Double> arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private int partition(List<Double> arr, int low, int high) {
        int middle = low + (high - low) / 2;
        Double pivot = arr.get(middle);
        Double temp = arr.get(middle);
        arr.set(middle, arr.get(high));
        arr.set(high, temp);

        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr.get(j) < pivot) {
                i++;

                temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            }
        }
        temp = arr.get(i+1);
        arr.set(i+1, arr.get(high));
        arr.set(high, temp);
        return i + 1;
    }
}
