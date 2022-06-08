package com.sergdalm.week6.task;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class WriterRunner {

    public static void main(String[] args) throws IOException {
        File file = Path.of("src", "main", "resources", "writer.poem").toFile();

        // Можно получить BufferWriter с помощью Files.newBufferedWriter(path)
        try (var fileWriter = new BufferedWriter(new FileWriter(file, true))) {
            fileWriter.append("Hello World!");
            fileWriter.newLine();
            fileWriter.append("Java");
        }
    }
}
