package com.sergdalm.week6.practice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * 3. Задан файл с текстом. В каждой строке найти и вывести
 * наибольшее число цифр, идущих подряд.
 */

public class Task3 {

    public static void main(String[] args) throws IOException {
        Path path = Path.of("src", "main", "resources", "test.txt");
        Files.readAllLines(path)
                .stream()
                .map(Task3::FindMaxDigitsCount)
                .filter(i -> i != 0)
                .forEach(System.out::println);
    }

    private static int FindMaxDigit(String s) {
        int number = 0;
        int biggestNumber = 0;

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                number = number * 10 + Character.getNumericValue(s.charAt(i));
            } else {
                biggestNumber = Math.max(number, biggestNumber);
                number = 0;
            }
        }
        return Math.max(number, biggestNumber);
    }

    private static int FindMaxDigitsCount(String s) {
        int result = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                count++;
            } else {
                result = Math.max(result, count);
                count = 0;
            }
        }
        return result = Math.max(result, count);
    }
}
