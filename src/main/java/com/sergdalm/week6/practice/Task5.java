package com.sergdalm.week6.practice;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.stream.Stream;

/**
 * 5. Задан файл с java-кодом. Прочитать текст программы из файла и
 * записать в другой файл в обратном порядке символы каждой
 * строки.
 */

public class Task5 {

    public static void main(String[] args) throws IOException {
        Path path = Path.of("src", "main", "java", "com", "sergdalm", "week5", "homework2", "Student.java");
        Path result = Path.of("src", "main", "resources", "ReversedStudent.txt");
        try (Stream<String> lines = Files.lines(path);
             BufferedWriter bufferedWriter = Files.newBufferedWriter(result, StandardOpenOption.APPEND)) {
            lines.map(StringBuilder::new)
                    .map(StringBuilder::reverse)
                    .forEach(line -> {
                        try {
                            bufferedWriter.write(line.toString());
                            bufferedWriter.write("\n");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        }
    }
}
