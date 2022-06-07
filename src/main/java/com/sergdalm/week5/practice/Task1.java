package com.sergdalm.week5.practice;

import java.util.List;

/**
 * 1. Дан список целых чисел. Найти среднее всех
 * нечётных чисел, делящихся на 5.
 */
public class Task1 {
    public static void main(String[] args) {
        var integers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0, -5, 55);
        var optionalDouble = integers.stream()
                .filter(n -> n % 5 == 0)
                .filter(n -> n % 2 != 0)
                .mapToInt(Integer::valueOf)
                .average();

        optionalDouble.ifPresent(System.out::println);

    }
}
