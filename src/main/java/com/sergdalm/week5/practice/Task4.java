package com.sergdalm.week5.practice;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 4. Дан список целых чисел, вывести строку,
 * представляющую собой конкатенацию
 * строковых представлений этих чисел.
 * Пример: список {5, 2, 4, 2, 1}
 * Результирующая строка: "52421"
 */
public class Task4 {
    public static void main(String[] args) {
        var integers = List.of(5, 2, 4, 2, 1);

        var result = integers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());

        System.out.println(result);
    }
}
