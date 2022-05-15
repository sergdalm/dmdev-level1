package com.sergdalm.week2.homework.arrays;

/**
 * Дан одномерный массив символов.
 * Преобразовать его в одномерный массив чисел,
 * где число - это код символа (любой символ - это число в памяти компьютера).
 * Например: [‘a’, ‘6’, ‘y’, ‘P’, ‘T’, ‘q’, ‘9’, ‘+’] -> [97, 54, 121, 80, 84, 113, 57, 43]
 * <p>
 * Далее определить среднее арифметическое всех элементов целочисленного массива
 * и вывести на консоль только те элементы, которые больше этого среднего арифметического.
 */
public class Task2 {

    public static void main(String[] args) {
        char[] charArray = {'a', 'b', '5', 'ц', 'D', 'ㅎ', ')'};
        int[] intArray = convertIntoIntArray(charArray);
        int average = getAverageValue(intArray);
        printBiggerNumbers(intArray, average);
    }

    private static void printBiggerNumbers(int[] array, int minLimit) {
        for (int element : array) {
            if (element > minLimit) {
                System.out.print(element + " ");
            }
        }
        System.out.println();
    }

    public static int getAverageValue(int[] array) {
        int sum = 0;
        for (int element : array) {
            sum += element;
        }
        return sum / array.length;
    }

    public static int[] convertIntoIntArray(char[] charArray) {
        int[] intArray = new int[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            intArray[i] = charArray[i];
        }
        return intArray;
    }
}
