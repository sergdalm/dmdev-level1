package com.sergdalm.week6.homework;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public final class CsvHelper {
    private static final String COMMA_DELIMITER = ",";

    public static Map<String, String> getValuesInFirstTwoColumns(Path itemPricePath) throws IOException {
        try (Stream<String> lines = Files.lines(itemPricePath)) {
            return lines.map(line -> line.contains(COMMA_DELIMITER) ?
                            line.split(COMMA_DELIMITER) : new String[]{line})
                    .collect(toMap(s -> s.length >= 1 ? s[0] : "",
                            s -> s.length >= 2 ? s[1] : "",
                            (existingValue, newValue) -> existingValue,
                            LinkedHashMap::new));
        }
    }

    public static void mapAndWriteValuesByFirstValue(Map<String, String> firstValues,
                                                     Map<String, String> secondValues,
                                                     Path resultPath, Path errorPath) throws IOException {
        if (!(firstValues.keySet().containsAll(secondValues.keySet()) &&
                secondValues.keySet().containsAll(firstValues.keySet()))) {
            writeErrorItems(errorPath, firstValues.keySet(), secondValues.keySet());
        }
        List<String> resultList = new ArrayList<>();
        for (String key : firstValues.keySet()) {
            if (secondValues.containsKey(key)) {
                resultList.add(key + "," + (secondValues.getOrDefault(key, "")) + ","
                        + firstValues.getOrDefault(key, ""));
            }
        }
        Files.write(resultPath, resultList, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }

    private static void writeErrorItems(Path errorPath,
                                        Set<String> keySet1,
                                        Set<String> keySet2) throws IOException {
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(errorPath,
                StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)) {
            Set<String> biggestSet = keySet1.size() > keySet2.size() ? keySet1 : keySet2;
            Iterator<String> iterator = biggestSet.iterator();
            if (iterator.hasNext()) {
                bufferedWriter.write(iterator.next());
                bufferedWriter.newLine();
            }
            for (String key : biggestSet) {
                if (!(keySet2.contains(key) && keySet1.contains(key))) {
                    bufferedWriter.write(key);
                }
            }
        }
    }
}