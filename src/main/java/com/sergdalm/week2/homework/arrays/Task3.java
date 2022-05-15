package com.sergdalm.week2.homework.arrays;

import java.util.Arrays;

/**
 * Дан одномерный массив целых чисел.
 * <p>
 * Написать функцию, которая принимает этот массив
 * и разбивает на 3 других: с только отрицательными числами,
 * только положительными и только нули.
 * Если для какого-то из массивов не будет значений,
 * то должен быть создан пустой массив.
 * Возвращает функция эти три массива в виде одного двумерного.
 * <p>
 * Пример:
 * [-4, 0, 1, 9, 0, -18, 3] ->
 * [-4, -18]
 * [0, 0]
 * [1, 9, 3]
 */
public class Task3 {

    public static void main(String[] args) {
        int[] values = {-4, 0, 1, 9, 0, -18, 3};
        int[][] separatedValues = separateArray(values);
        System.out.println(Arrays.toString(separatedValues[0]));
        System.out.println(Arrays.toString(separatedValues[1]));
        System.out.println(Arrays.toString(separatedValues[2]));
    }

    public static int[][] separateArray(int[] values) {
        int positiveCount = 0;
        int negativeCount = 0;
        int zeroCount = 0;

        for (int value : values) {
            if (value > 0) {
                positiveCount++;
            } else if (value < 0) {
                negativeCount++;
            } else {
                zeroCount++;
            }
        }

        int[][] separatedValues = {
                new int[negativeCount],
                new int[zeroCount],
                new int[positiveCount]
        };

        positiveCount = 0;
        negativeCount = 0;
        zeroCount = 0;
        for (int value : values) {
            if (value < 0) {
                separatedValues[0][negativeCount++] = value;
            } else if (value > 0) {
                separatedValues[2][positiveCount++] = value;
            } else {
                separatedValues[1][zeroCount++] = value;
            }
        }
        return separatedValues;
    }
}
