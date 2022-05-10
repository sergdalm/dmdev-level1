package com.sergdalm.week1.homework.loops;

/**
 * Задание 1
 * Посчитать четные и нечетные цифры целого числа и вывести их на консоль.
 * Для решения написать 2 функции, которые будут принимать введенное целое число,
 * а возвращать количество четных цифр (вторая функция - нечетных).
 * <p>
 * Например: если введено число 228910, то у него 4 четные цифры (2, 2, 8, 0) и 2 нечетные (9, 1).
 */

public class Task1 {

    public static void main(String[] args) {
        int number = 228910;
        int numberOfEvenNumbers = getAmountOfEvenNumbers(number);
        int numberOfOddNumbers = getAmountOfOddNumbers(number);

        System.out.println("Amount of even numbers in " + number + ": " + numberOfEvenNumbers);
        System.out.println("Amount of odd numbers in " + number + ": " + numberOfOddNumbers);
    }

    private static int getAmountOfEvenNumbers(int number) {
        int count = 0;
        for (int i = number; i > 1; i /= 10) {
            if ((i % 10) % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    private static int getAmountOfOddNumbers(int number) {
        int count = 0;
        for (int i = number; i > 1; i /= 10) {
            if ((i % 10) % 2 != 0) {
                count++;
            }
        }
        return count;
    }
}
