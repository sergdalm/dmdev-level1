package com.sergdalm.week5.practice;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 2. Дан список строк. Найти количество уникальных
 * строк длиной более 8 символов.
 */
public class Task2 {
    public static void main(String[] args) {
        List<String> strings = List.of("string-1",
                "string-1",
                "string-1",
                "string-10",
                "string-10",
                "string-11",
                "string-11",
                "string-12"
        );

        var count = strings.stream()
                .filter(s -> s.length() > 8)
                .distinct()
                .count();

        System.out.println(count);
    }
}
