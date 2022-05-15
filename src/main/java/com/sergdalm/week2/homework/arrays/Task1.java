package com.sergdalm.week2.homework.arrays;

import java.util.Arrays;

/**
 * Дан одномерный массив целых чисел.
 * Написать функцию, удаляющую из него все отрицательные элементы
 * (удалить - значит создать новый массив с только положительными элементами).
 * После удаления - умножить каждый элемент массива на его длину.
 * Например: [3, 5, -6, 3, 2, -9, 0, -123] -> [15, 25, 15, 10, 0]
 * <p>
 * Не забывать, что всю логику приложения нужно выносить в отдельные функции.
 * main - только для тестирования написанного функционала.
 */
public class Task1 {

    public static void main(String[] args) {
        int[] values = {1, -2, 3, -4, 5, -6, 7, -8, 9, 0};
        int[] nonNegativeValues = removeNegativeNumbers(values);
        System.out.println(Arrays.toString(nonNegativeValues));
    }

    public static int[] removeNegativeNumbers(int[] values) {
        int[] nonNegativeArray = new int[calculateNonNegativeNumbers(values)];
        int i = 0;
        for (int value : values) {
            if (value >= 0) {
                nonNegativeArray[i++] = value * nonNegativeArray.length;
            }
        }
        return nonNegativeArray;
    }

    private static int calculateNonNegativeNumbers(int[] values) {
        int result = 0;
        for (int value : values) {
            if (value >= 0)
                result++;
        }
        return result;
    }
}
