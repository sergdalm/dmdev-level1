package com.sergdalm.week6.practice;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

/**
 * 1. Задан файл с текстом, найти и вывести в консоль все слова,
 * начинающиеся с гласной буквы.
 */
public class Task1 {
    private static final String VOWELS = "уеыаояи";

    public static void main(String[] args) throws IOException {
        Path path = Path.of("src", "main", "resources", "test.txt");
        try (Scanner in = new Scanner(path)) {
            while (in.hasNext()) {
                String word = in.next();
                if (VOWELS.indexOf(word.charAt(0)) != -1)
                    System.out.println(word);
            }
        }
    }

}
