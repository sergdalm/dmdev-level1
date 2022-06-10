package com.sergdalm.week6.task;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.TRUNCATE_EXISTING;

/**
 * Создать программно и заполнить файл случайными целыми числами.
 * После чего отсортировать содержимое файла по возрастанию
 * (т.е. перезаписать файл с новым порядком чисел)
 */
public class Task2 {
    private static final Random RANDOM = new Random();
    private static final int DEFAULT_BOUND = 1000;

    public static void main(String[] args) throws IOException {
        Path path = Path.of("src", "main", "resources", "random.txt");

        Files.write(path, getRandomNumbersAsList(DEFAULT_BOUND), CREATE, TRUNCATE_EXISTING);
        Files.write(path, sortNumbers(path), TRUNCATE_EXISTING);
    }

    private static List<String> sortNumbers(Path path) throws IOException {
        try (Stream<String> lines = Files.lines(path, UTF_8)) {
            return lines.map(Integer::valueOf)
                    .sorted()
                    .map(String::valueOf)
                    .toList();
        }
    }

    private static List<String> getRandomNumbersAsList(int amountOfNumbers) {
        List<String> randomNumbers = new ArrayList<>(amountOfNumbers);
        for (int i = 0; i < amountOfNumbers; i++) {
            randomNumbers.add(RANDOM.nextInt() + "");
        }
        return randomNumbers;
    }

}
