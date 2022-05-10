package com.sergdalm.week1.task.loops;

import java.util.Scanner;

/**
 * Написать программу, вычисляющую и отображающую все числа Фибоначчи меньше
 * введённого пользователем целого числа.
 * Решить двумя способами: с помощью цикла и с помощью рекурсии.
 */
public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number;
        System.out.println("Write number and press 'Enter':");
        while (true) {
            try {
                String str = scanner.nextLine();
                number = Integer.parseInt(str);
                break;
            } catch (Exception exc) {
                // Ignore exception
            }
        }
        showFibonacciFor(number);
        showFibonacciFor2(number);
        showFibonacciRecursion(number);
        System.out.println(fib2(number));
        System.out.println(fib3(number));
    }

    private static void showFibonacciRecursion(int number) {
        fibonacci(0, 1, number);
        System.out.println();
    }

    private static void fibonacci(int first, int second, int threshold) {
        if (second < threshold) {
            System.out.print(second + " ");
            fibonacci(second, first + second, threshold);
        }
    }

    private static void showFibonacciFor(int number) {
        int previousNumber1 = 0;
        int previousNumber2 = 1;
        if (number >= 1) {
            System.out.print(1 + " ");
        }
        for (int i = 1; i < number; i++) {
            if (previousNumber1 + previousNumber2 == i) {
                System.out.print(i + " ");
                previousNumber1 = previousNumber2;
                previousNumber2 = i;
            }
        }
        System.out.println();

    }

    private static void showFibonacciFor2(int threshold) {
        int first = 0;
        int second = 1;
        while (second < threshold) {
            System.out.print(second + " ");
            int next = first + second;
            first = second;
            second = next;
        }
        System.out.println();
    }

    // Получение значения числа n в последовательности Фибоначчи.
    private static int fib2(int n) {
        if (n < 2) {
            return n;
        }
        return fib2(n - 1) + fib2(n - 2);
    }

    private static int fib3(int n) {
        int first = 0;
        int second = 1;
        for (int i = 0; i < n; i++) {
            int next = first + second;
            first = second;
            second = next;
        }
        return first;
    }
}
