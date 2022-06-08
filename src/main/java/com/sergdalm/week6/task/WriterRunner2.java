package com.sergdalm.week6.task;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class WriterRunner2 {

    public static void main(String[] args) throws IOException {
        Path path = Path.of("src", "main", "resources", "writer2.poem");

        Files.write(path, List.of("Hello world!", "Java"));
    }
}
