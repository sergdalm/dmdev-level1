package com.sergdalm.week5.practice;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 3. Дана Map<String, Integer>. Найти сумму всех
 * значений, длина ключей которых меньше 7
 * символов.
 */

public class Task3 {
    public static void main(String[] args) {
        Map<String, Integer> map = Map.of(
                "one", 1,
                "two", 2,
                "three", 3,
                "twenty one", 21,
                "nineteen", 19
        );

        // Способ 1
        var sum1 = map.keySet().stream()
                .filter(s -> s.length() < 7)
                .mapToInt(map::get)
                .sum();

        System.out.println(sum1);

        // Способ 2 (dmdev)
        var sum2 = map.entrySet().stream()
                .filter(entry -> entry.getKey().length() < 7)
                .mapToInt(Map.Entry::getValue)
                .sum();

        System.out.println(sum2);

        // Способ 3 (как Способ 2, но вместо sum() используется reduce()
        var sum3 = map.entrySet().stream()
                .filter(entry -> entry.getKey().length() < 7)
                .mapToInt(Map.Entry::getValue)
                .reduce(0, Integer::sum);

        System.out.println(sum3);
    }
}
