package com.sergdalm.week8.homework.runnable;

import com.sergdalm.week8.homework.dto.ClaimLogFileRow;
import com.sergdalm.week8.homework.dto.PhoneNumber;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class ClaimLogFileParser implements Runnable {
    private static final long TIMEOUT = 60_000L * 2L;
    private static final String ID_GROUP = "id";
    private static final String DAY_GROUP = "day";
    private static final String MONTH_GROUP = "month";
    private static final String YEAR_GROUP = "year";
    private static final String HOUR_GROUP = "hour";
    private static final String MINUTE_GROUP = "minute";
    private static final String SECOND_GROUP = "second";
    private static final String NAME_GROUP = "name";
    private static final String PHONE_CITY_CODE_GROUP = "cityCode";
    private static final String PHONE_FIRST_PART_GROUP = "firstPart";
    private static final String PHONE_SECOND_PART_GROUP = "secondPart";
    private static final String PHONE_THIRD_PART_GROUP = "thirdPart";
    private static final String CLAIM_GROUP = "claim";
    private static final String LOG_FILE_REGEX = "^(?<id>\\d+), " +
            "(?<year>\\d{4})-(?<month>\\d{2})-(?<day>\\d{2})T(?<hour>\\d{2}):(?<minute>\\d{2}):(?<second>\\d{2}), " +
            "(?<name>[А-Яа-яЁё]+ [А-Яа-яЁё]+), " +
            "(\\+)?(375)? ?\\(?(?<cityCode>\\d{2})\\)? ?(?<firstPart>\\d{3}) ?(?<secondPart>\\d{2}) ?(?<thirdPart>\\d{2}), " +
            "(?<claim>.+)$";
    private static final Pattern PATTERN = Pattern.compile(LOG_FILE_REGEX);
    private final Path path;
    private final Queue<ClaimLogFileRow> claims;
    private int lastRow;
    private AtomicBoolean isLogFileParsed;

    public ClaimLogFileParser(Path path, Queue<ClaimLogFileRow> claims, AtomicBoolean isLogFileParsed) {
        this.path = path;
        this.claims = claims;
        this.isLogFileParsed = isLogFileParsed;
    }

    @Override
    public void run() {
        while (true) {
            parseLogFile();
            isLogFileParsed.set(true);
            takeTimeout();
        }
    }

    private void parseLogFile() {
        try (Stream<String> lines = Files.lines(path)) {
            lines.skip(lastRow)
                    .map(PATTERN::matcher)
                    .filter(Matcher::find)
                    .map(matcher -> {
                        int id = Integer.parseInt(matcher.group(ID_GROUP));
                        LocalDateTime time = LocalDateTime.of(
                                Integer.parseInt(matcher.group(YEAR_GROUP)),
                                Integer.parseInt(matcher.group(MONTH_GROUP)),
                                Integer.parseInt(matcher.group(DAY_GROUP)),
                                Integer.parseInt(matcher.group(HOUR_GROUP)),
                                Integer.parseInt(matcher.group(MINUTE_GROUP)),
                                Integer.parseInt(matcher.group(SECOND_GROUP)));
                        String name = matcher.group(NAME_GROUP);
                        PhoneNumber phoneNumber = new PhoneNumber(
                                matcher.group(PHONE_CITY_CODE_GROUP),
                                matcher.group(PHONE_FIRST_PART_GROUP),
                                matcher.group(PHONE_SECOND_PART_GROUP),
                                matcher.group(PHONE_THIRD_PART_GROUP));
                        String claim = matcher.group(CLAIM_GROUP);
                        lastRow++;
                        return new ClaimLogFileRow(id, time, name, phoneNumber, claim);
                    })
                    .forEach(claims::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void takeTimeout() {
        try {
            Thread.sleep(TIMEOUT);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
