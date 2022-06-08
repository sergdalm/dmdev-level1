package com.sergdalm.week6.task;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReaderRunner2 {
    public static void main(String[] args) throws IOException {
        var path = Path.of("src", "main", "resources", "test.txt");

        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(System.out::println);
        }

        Files.readAllLines(path)
                .forEach(System.out::println);

    }
}
