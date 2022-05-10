package com.sergdalm.week1.task.loops;

import java.util.Scanner;

// Проверить код на возможность сузить область видемости
public class Task1 {

    public static void main(String[] args) {
        System.out.println("Write number and press 'Enter':");
        int number = getNumber();
        int sum = calculateSumOfDigits(number);
        System.out.println("Sum digits of number " + number + ": " + sum);
    }

    private static int calculateSumOfDigits(int number) {
        int result = 0;
        for (int i = 0; i < number; i++) {
            result += i;
        }
        return result;
    }

    private static int getNumber() {
        Scanner scanner = new Scanner(System.in);
        boolean isNumber = false;
        while (true) {
            try {
                String str = scanner.nextLine();
                return Integer.parseInt(str);
            } catch (Exception exc) {
                // Ignore exception
            }
        }
    }
}
