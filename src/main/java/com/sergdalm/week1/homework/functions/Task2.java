package com.sergdalm.week1.homework.functions;

import java.util.*;

/**
 * Даны 3 переменные:
 * <p>
 * - operand1 (double)
 * - operand2 (double)
 * - operation (char ‘+’, ‘-’, ‘*’, ‘/’, ‘%’)
 * <p>
 * Написать функцию, которая принимает в качестве параметров эти три переменные и возвращает результат операции.
 * Протестировать функцию в main.
 * <p>
 * Например:
 * Параметры: operand1 = 24.4, operand2 = 10.1, operation = ‘+’
 * Результат: 34.5 (24.4 + 10.1)
 */
public class Task2 {

    public static void main(String[] args) {

        System.out.println("Input operand1 and press 'Enter':");
        double operand1 = getDouble();
        System.out.println("Input operand2 and press 'Enter':");
        double operand2 = getDouble();
        System.out.println("Input operation symbol and press 'Enter':");
        char operation = getOperation();

        System.out.println(operand1 + " " + operation + " " + operand2 + " = " +
                calculate(operand1, operand2, operation));
    }

    public static double calculate(double operand1, double operand2, char operation) {
        if (operation == '+') {
            return operand1 + operand2;
        } else if (operation == '-') {
            return operand1 - operand2;
        } else if (operation == '*') {
            return operand1 * operand2;
        } else if (operation == '/') {
            return operand1 / operand2;
        } else if (operation == '%') {
            return operand1 % operand2;
        } else {
            System.out.println("There is no such operation!");
            return 0;
        }
    }

    private static char getOperation() {

        Scanner scanner = new Scanner(System.in);
        String input = "";
        do {
            try {
                input = scanner.nextLine();
            } catch (Exception exc) {
                // Ignore wrong input
            }
        } while (!validateOperator(input));
        return input.charAt(0);
    }

    private static double getDouble() {
        Scanner scanner = new Scanner(System.in);
        for (; ; ) {
            try {
                String input = scanner.nextLine();
                return Double.parseDouble(input);
            } catch (Exception exc) {
                // Ignore wrong input
            }
        }
    }

    private static boolean validateOperator(String str) {
        List<String> operations = List.of("+", "-", "*", "/", "%");
        return operations.contains(str);
    }
}
