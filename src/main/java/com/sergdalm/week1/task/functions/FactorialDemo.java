package com.sergdalm.week1.task.functions;

public class FactorialDemo {

    public static void main(String[] args) {
        int value = 3;
        int factorial = getFactorial(value);
        System.out.println(factorial);
    }

    private static int getFactorial(int value) {
        if (value == 1) {
            return value;
        } else {
            return value * getFactorial(value - 1);
        }
    }
}
