package com.study.naumen.homework2;

import java.util.ArrayList;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        List<Double> arr = new ArrayList<>();
        for(int i = 0; i < 101; i++){
            arr.add(Math.random());
        }
        quickSort(arr,0, 100);
        System.out.println(arr);
    }
    public static void quickSort(List<Double> arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(List<Double> arr, int low, int high) {
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
