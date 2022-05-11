package com.sergdalm.week2.task.arrays;

import java.util.Arrays;

/**
 * Заданы 2 массива целых чисел произвольной длины.
 * Написать программу, создающую третий массив,
 * представляющий собой слияние 2-х заданных.
 * <p>
 * Пример:
 * 1-й массив: {1, 2, 3, 4, 5}
 * <p>
 * 2-й массив: {5, 6, 7}
 * <p>
 * Результат: {1, 5, 2, 6, 3, 7, 4, 5}
 */
public class Task3 {

    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5, 6};
        int[] array2 = {7, 8, 9, 0};
        int[] mergedArray = mergeArrays(array1, array2);
        System.out.println(Arrays.toString(mergedArray));
    }

    private static int[] mergeArrays(int[] array1, int[] array2) {
        int[] mergedArray = new int[array1.length + array2.length];
        int maxIndex = Math.max(array1.length, array2.length);
        for (int i = 0, j = 0; i < maxIndex; i++) {
            if (i < array1.length) {
                mergedArray[j++] = array1[i];
            }
            if (i < array2.length) {
                mergedArray[j++] = array2[i];
            }
        }
        return mergedArray;
    }
}
