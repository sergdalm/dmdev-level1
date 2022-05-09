package com.sergdalm.week1.homework.loops;

/**
 * Дано целое число.
 * Написать функцию, которая принимает целое число, а возвращает целое число обратное этому (не строку!).
 * Результат вывести на консоль.
 * Например: 4508 -> 8054, 4700 -> 74, 1234567 -> 7654321
 * <p>
 * Примечание: для решения может понадобится функция возведение числа в степень: Math.pow(число, степень)
 */
public class Task2 {

    public static void main(String[] args) {
        int number = 1234567;
        int reversedNumber = getReversedNumber(number);
        System.out.println(reversedNumber);
    }

    public static int getReversedNumber(int number) {
        int count = 0;
        for (int i = number; i >= 1; i /= 10) {
            count++;
        }

        int result = 0;
        for (int n = number, i = 0, j = count - 1; i < count; n /= 10, i++, j--) {
            result += (n % 10) * Math.pow(10, j);
        }
        return result;
    }
}
