package com.sergdalm.week2.homework.strings;

/**
 * Дана строка с текстом, в котором есть цифры от 0 до 9.
 * Написать 2 метода:
 * - возвращающий массив цифр из переданной строки
 * - возвращающий сумму цифр из переданного целочисленного массива
 * Посчитать сумму всех чисел из строки
 * <p>
 * Например:
 * “Привет 8, как 1 2 твои дела? Может4, сделать 3 дело?” -> 18 (8+1+2+4+3)
 */
public class Task2 {

    public static void main(String[] args) {
        String str = "Привет 8, как 1 2 твои дела? Может4, сделать 3 дело?";
        int[] numbers = getIntArray(str);
        int sum = getSum(numbers);
        System.out.println(sum);
    }

    public static int getSum(int[] numbers) {
        int result = 0;
        for (int number : numbers) {
            result += number;
        }
        return result;
    }

    public static int[] getIntArray(String str) {
        int asciiZero = 48;
        int asciiNine = 57;
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= asciiZero && c <= asciiNine) {
                count++;
            }
        }
        int[] intArray = new int[count];

        for (int i = 0, j = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= asciiZero && c <= asciiNine) {
                intArray[j] = Integer.parseInt(str.substring(i, i + 1));
                j++;
            }
        }
        return intArray;
    }
}
