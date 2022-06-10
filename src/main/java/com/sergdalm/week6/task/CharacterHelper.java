package com.sergdalm.week6.task;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

public class CharacterHelper {
    public static Map<Character, Integer> calcFrequency(Path path) throws IOException {
        try (Stream<String> lines = Files.lines(path)) {
            return lines.map(String::chars)
                    .flatMapToInt(identity())
                    .mapToObj(intValue -> (char) intValue)
                    .filter(Character::isLetter)
                    .map(Character::toLowerCase)
                    .collect(toMap(identity(), it -> 1, Integer::sum));

        }
    }

    public static List<String> toListRepresentation(Map<Character, Integer> charFrequency) {
        return charFrequency.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(entre -> entre.getKey() + " - " + entre.getValue())
                .toList();
    }
}
