package com.study.naumen;

import com.study.naumen.homework2.Task1;
import com.study.naumen.homework2.Task2;
import com.study.naumen.homework2.task3.Task3;
import com.study.naumen.homework2.task4.Task4;
import com.study.naumen.homework2.task5.Task5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Enter task number: ");
        Scanner sc = new Scanner(System.in);
        int taskNum = sc.nextInt();
        switch (taskNum) {
            case 1:
                new Task1().run();
                break;
            case 2:
                new Task2().run();
                break;
            case 3:
                new Task3().run();
                break;
            case 4:
                new Task4().run();
                break;
            case 5:
                new Task5().run();
                break;
        }
    }
}