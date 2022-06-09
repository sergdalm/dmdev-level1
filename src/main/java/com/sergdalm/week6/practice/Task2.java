package com.sergdalm.week6.practice;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

/**
 * 2. Задан файл с текстом, найти и вывести в консоль все слова,  для
 * которых последняя буква одного слова совпадает с первой буквой
 * следующего слова
 */

public class Task2 {

    public static void main(String[] args) throws IOException {
        Path path = Path.of("src", "main", "resources", "test.txt");
        try (Scanner scanner = new Scanner(path)) {
            String previousWord = null;

            while (scanner.hasNext()) {
                String word = scanner.next();
                if (previousWord != null) {
                    if (word.charAt(0) == previousWord.charAt(previousWord.length() - 1)) {
                        System.out.print(previousWord);
                        System.out.print(" ");
                        System.out.print(word);
                        System.out.println();
                    }
                }
                previousWord = word;
            }
        }

    }
}
