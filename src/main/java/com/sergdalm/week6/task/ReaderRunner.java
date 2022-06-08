package com.sergdalm.week6.task;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.Collectors;

public class ReaderRunner {
    public static void main(String[] args) throws IOException {
        var file = Path.of("src", "main", "resources", "test.txt").toFile();
        try (var fileReader = new BufferedReader(new FileReader(file))) {
            var collect = fileReader.lines()
                    .collect(Collectors.joining("\n"));
            System.out.println(collect);
        }
    }
}
