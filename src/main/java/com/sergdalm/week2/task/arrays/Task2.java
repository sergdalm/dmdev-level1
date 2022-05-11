package com.sergdalm.week2.task.arrays;

import java.util.Arrays;

/**
 * Написать программу, удаляющую все повторяющиеся целые числа из массива
 * и печатающую результат. Массив должен использоваться тот же самый.
 * На место удаленных элементов ставить цифру 0.
 */
public class Task2 {

    public static void main(String[] args) {
        int[] values = new int[1000];
        fillArray(values);

        long start = System.currentTimeMillis();
        deleteRepeatedValues(values);
        double end = System.currentTimeMillis();
        double elapsedTime1 = end - start;

        fillArray(values);

        start = System.currentTimeMillis();
        removeDuplicates(values);
        end = System.currentTimeMillis();
        double elapsedTime2 = end - start;

        System.out.println("My version: " + elapsedTime1);
        System.out.println("Dmdev version: " + elapsedTime2);
    }

    // my version
    private static void deleteRepeatedValues(int[] array) {
        int[] nonRepeatedValues = new int[array.length];
        int count = 0;
        boolean repeated;
        for (int i = 0; i < array.length; i++) {
            repeated = false;
            if (array[i] != 0) {
                for (int j = 0; nonRepeatedValues[j] != 0; j++) {
                    if (array[i] == nonRepeatedValues[j]) {
                        array[i] = 0;
                        repeated = true;
                        break;
                    }
                }
            } else {
                continue;
            }
            if (repeated) {
                continue;
            }
            nonRepeatedValues[count++] = array[i];
        }
        for (int i = 0; nonRepeatedValues[i] != 0; i++) {
            if (array[0] == nonRepeatedValues[i]) {
                array[0] = 0;
                break;
            }
        }
    }

    //dmdev version
    private static void removeDuplicates(int[] values) {
        for (int i = 0; i < values.length; i++) {
            for (int j = i + 1; j < values.length; j++) {
                if (values[i] == values[j]) {
                    values[j] = 0;
                }
            }
        }
    }

    private static void fillArray(int[] values) {
        for (int i = 0; i < values.length; i++) {
            if (i % 2 == 0) {
                values[i] = 2;
            } else if (i % 3 == 0) {
                values[i] = 3;
            } else {
                values[i] = i;
            }
        }
    }
}
