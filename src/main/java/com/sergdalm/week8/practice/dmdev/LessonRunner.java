package com.sergdalm.week8.practice.dmdev;

import com.sergdalm.week8.practice.dmdev.parser.LogFileParser;
import com.sergdalm.week8.practice.dmdev.report.StatisticReportGenerator;
import com.sergdalm.week8.practice.dmdev.report.TimeReportGenerator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.TRUNCATE_EXISTING;

public class LessonRunner {

    public static void main(String[] args) throws IOException {
        // src/main/resources/log-file
        var logFilePath = Path.of("src", "main", "resources", "log-file.txt");
        var logFileParser = new LogFileParser();
        var logFileDays = logFileParser.parse(logFilePath);

        var timeReportGenerator = new TimeReportGenerator();
        var timeReport = timeReportGenerator.generate(logFileDays);
        Files.writeString(Path.of("src", "main", "resources", "time-report.txt"), timeReport, CREATE, TRUNCATE_EXISTING);

        var statisticReportGenerator = new StatisticReportGenerator();
        var statisticReport = statisticReportGenerator.generate(logFileDays);
        Files.writeString(Path.of("src", "main", "resources", "statistic-report.txt"), statisticReport, CREATE, TRUNCATE_EXISTING);
    }
}
