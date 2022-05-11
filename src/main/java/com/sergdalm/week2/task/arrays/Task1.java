package com.sergdalm.week2.task.arrays;

import java.util.Arrays;

/**
 * Напишите программу, которая циклически сдвигает элементы массива вправо
 * на одну позицию, и печатает результат. Цикличность означает,
 * что последний элемент массива становится самым первым его элементом.
 */
public class Task1 {

    public static void main(String[] args) {
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] shiftedValues = shiftArray(values, 1);
        System.out.println(Arrays.toString(shiftedValues));
    }

    private static int[] shiftArray(int[] values, int shift) {
        if (shift == 0) {
            return values;
        }

        if (shift > values.length || -shift > values.length) {
            System.out.println("Shift can't be bigger than array's length!");
            return values;
        }

        int[] shiftedArray = new int[values.length];
        int j;
        if (shift > 0) {
            j = shift;
            for (int i = 0; i < values.length - shift; i++, j++) {
                shiftedArray[j] = values[i];
            }
            j = 0;
            for (int i = values.length - shift; i < values.length; i++, j++) {
                shiftedArray[j] = values[i];
            }
        }
        if (shift < 0) {
            j = 0;
            int positiveShift = -shift;
            for (int i = positiveShift; i < values.length; i++, j++) {
                shiftedArray[j] = values[i];
            }
            for (int i = 0; i < positiveShift; i++, j++) {
                shiftedArray[j] = values[i];
            }
        }
        return shiftedArray;
    }
}
