package com.sergdalm.week8.practice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * Задан log-file с описанием четырёхдневных курсов в следующем виде:
 * 09:20 Введение
 * 11:00 Упражнения
 * 11:15 Перерыв
 * 11:35 Скаляры
 * 12:30 Обеденный перерыв
 * 13:30 Упражнения
 * 14:10 Решения
 * 14:30 Перерыв
 * 14:40 Массивы
 * 15:40 Упражнения
 * 17:00 Решения
 * 17:30 Конец
 * <p>
 * 09:30 Углубленное изучение массивов
 * 10:30 Перерыв
 * 10:50 Упражнения
 * ...
 * <p>
 * Каждая строка начинается со времени, за которым следует описание активности.
 * Пустые строки разделяют дни. Некоторые активности представляют собой названия
 * лекций, например "Введение", "Скаляры", "Массивы". Другие - названия определённых
 * повторяющихся отрезков времени: "Упражнения", "Перерыв", "Решения" и т.д.
 * Словом "Конец" отмечается конец дня.
 * <p>
 * Задание:
 * Используя регулярные выражения считать данные из файла, а затем сгенерировать
 * два отчёта в двух разных файлах в следующем виде:
 * 1. В виде временных отрезков
 * 09:20-11:00 Введение
 * 11:00-11:15 Упражнения
 * 11:15-11:35 Перерыв
 * ...
 * <p>
 * 2. В виде общего времени, потраченного на активности за день, и детализированного описания лекций:
 * Лекции: 210 минут 22%
 * Решения: 95 минут 9%
 * Перерыв: 65 минут 6%
 * ...
 * Лекции:
 * Введение: 23 минуты 2%
 * ...
 */
public class Task {

    public static void main(String[] args) throws IOException {
        Path logFilePath = Path.of("src", "main", "resources", "log-file.txt");
        String logFile = Files.readString(logFilePath);

        String regex = "(\\d{2}:\\d{2}) (.+?)\n";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(logFile);
        Map<String, String> lessons = new LinkedHashMap<>();
        while (matcher.find()) {
            lessons.put(matcher.group(1), matcher.group(2));
        }

        Set<String> keySet = lessons.keySet();
        List<String> result = new ArrayList<>();
        Iterator<String> iterator = keySet.iterator();



    }
}
