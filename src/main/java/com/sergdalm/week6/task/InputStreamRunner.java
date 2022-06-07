package com.sergdalm.week6.task;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;

public class InputStreamRunner {
    public static void main(String[] args) throws IOException {
//        File file = new File("resources/test.txt");
        var file = Path.of("src", "main", "resources", "test.txt").toFile();
        try (var inputStream = new FileInputStream(file)) {
            byte[] bytes = new byte[inputStream.available()];
            int counter = 0;
            byte currentByte;
            while ((currentByte = (byte) inputStream.read()) != -1) {
                bytes[counter++] = currentByte;
            }
            String stringValue = new String(bytes);
            System.out.println(stringValue);

//            var bytes = inputStream.readAllBytes();
//            var stringValue = new String(bytes);
//            System.out.println(stringValue);
        }
    }
}
