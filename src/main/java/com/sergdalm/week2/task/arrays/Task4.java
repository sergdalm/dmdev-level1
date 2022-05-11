package com.sergdalm.week2.task.arrays;

import java.util.Arrays;

/**
 * Написать функцию linearize, которая принимает в качестве параметра двумерный массив
 * и возвращает одномерный массив со всеми элементами двумерного.
 */
public class Task4 {

    public static void main(String[] args) {
        int[][] values = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {0}
        };

        int[] values2 = convertToOneDimensionalArray(values);
        System.out.println(Arrays.toString(values2));
    }

    private static int[] convertToOneDimensionalArray(int[][] twoDimensionalArray) {
        int count = 0;
        for (int[] ints : twoDimensionalArray) {
            count += ints.length;
        }

        int[] oneDimensionalArray = new int[count];
        count = 0;

        for (int[] ints : twoDimensionalArray) {
            for (int anInt : ints) {
                oneDimensionalArray[count++] = anInt;
            }
        }
        return oneDimensionalArray;
    }
}
