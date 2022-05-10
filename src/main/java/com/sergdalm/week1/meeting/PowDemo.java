package com.sergdalm.week1.meeting;

/**
 * Напишите программу, которая принимает два числа, и возводит первое в степень другого
 * не используя Math.povw
 */
public class PowDemo {
    public static void main(String[] args) {
        int result = pow(2, 5);
        System.out.println(result);
    }

    private static int pow(int number, int pow) {
        int result = number;
        for (int i = 1; i < pow; i++) {
            result *= number;
        }
        return result;
    }
}
