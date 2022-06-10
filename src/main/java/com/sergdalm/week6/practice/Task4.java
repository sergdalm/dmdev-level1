package com.sergdalm.week6.practice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * 4. Задан файл с java-кодом. Прочитать текст программы из файла и
 * все слова public в объявлении атрибутов и методов класса заменить
 * на слово private. Результат сохранить в другой заранее созданный
 * файл.
 */

public class Task4 {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("src", "main", "java", "com", "sergdalm", "week5", "homework2", "Student.java");
        String string = Files.readString(path);

        String result = string.replace("public", "private");

        Path resultPath = Path.of("src", "main", "resources", "StudentPublic.txt");
        Files.writeString(resultPath, result);

    }
}
