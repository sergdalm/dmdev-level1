package com.sergdalm.week6.homework;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;

/**
 * Даны два файла в формате CSV.
 * Формат первого файла items-price.csv:
 * ID,PRICE
 * 1,9.98
 * 2,25.05
 * 3,16.45
 * <p>
 * Формат второго файла items-name.csv:
 * ID,NAME,DESCRIPTION
 * 1,Шарф,Теплый зимний шарф красного цвета
 * 2,Шапка,Вязаная зеленая шапка
 * 3,Ботинки,Осенние ботинки на толстой подошве
 * <p>
 * Задача:
 * Считать оба CSV файла и объединить их по полю ID в один result.csv,
 * где будут следующие поля: ID,NAME,PRICE.
 * <p>
 * Желательно реализовать доп. функционал:
 * Если для каких-то ID не будет значений в обоих файлах,
 * то записать их в один файл errors.csv, где будет лишь одно поле ID.
 */
public class TaskRunner {

    public static void main(String[] args) throws IOException {
        Path itemPricePath = Path.of("src", "main", "resources", "items-price.csv");
        Path itemNamePath = Path.of("src", "main", "resources", "items-name.csv");
        Path resultPath = Path.of("src", "main", "resources", "result.csv");
        Path errorPath = Path.of("src", "main", "resources", "errors.csv");

        Map<String, String> prices = CsvHelper.getValuesInFirstTwoColumns(itemPricePath);
        Map<String, String> names = CsvHelper.getValuesInFirstTwoColumns(itemNamePath);
        CsvHelper.mapAndWriteValuesByFirstValue(prices, names, resultPath, errorPath);
    }
}