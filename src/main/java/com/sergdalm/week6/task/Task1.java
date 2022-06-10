package com.sergdalm.week6.task;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.TRUNCATE_EXISTING;

/**
 * Задан файл со стихотворением Александра Пушкина.
 * Определить частоту повторяемости всех букв в стихотворении, игнорируя регистр.
 * Вывести результат в файл в виде:
 * а - 15
 * б - 7
 * ....
 * я - 11
 */
public class Task1 {

    public static void main(String[] args) throws IOException {
        Path poemPath = Path.of("src", "main", "resources", "pushkin.txt");
        Path resultPath = Path.of("src", "main", "resources", "pushkinCount.txt");

        Map<Character, Integer> characterFrequency = CharacterHelper.calcFrequency(poemPath);
        Files.write(resultPath, CharacterHelper.toListRepresentation(characterFrequency), CREATE, TRUNCATE_EXISTING);

        List<String> list = Arrays.asList("3", "6", "8", "14", "15");

        List<Integer> integers = list.stream()
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();

        List<Integer> integers2 = list.stream()
                .flatMapToInt(num -> IntStream.of(Integer.parseInt(num)))
                .boxed()
                .toList();

        List<Integer> integers3 = list.stream()
                .map(Integer::valueOf)
                .toList();

        System.out.println(integers);
        System.out.println(integers2);
    }
}
