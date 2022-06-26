package com.sergdalm.week8.homework.runnable;

import com.sergdalm.week8.homework.dto.ClaimLogFileRow;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

import static com.sergdalm.week8.homework.util.DelimiterUtil.getCommaSpace;
import static java.time.LocalDateTime.now;

public class DispatcherTeam implements Runnable {
    private static final int NUMBER_OF_DISPATCHERS = 3;
    private static final long CALLING_TIME = 3000L;
    private static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm";
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATE_TIME_PATTERN);
    private final ExecutorService threadPool;
    private final Path outputPath;
    private final BlockingQueue<ClaimLogFileRow> claims;
    private volatile AtomicBoolean isLogFileParsed;

    public DispatcherTeam(Path outputPath, BlockingQueue<ClaimLogFileRow> claims, AtomicBoolean isLogFileParsed) {
        threadPool = Executors.newFixedThreadPool(NUMBER_OF_DISPATCHERS);
        this.outputPath = outputPath;
        this.claims = claims;
        this.isLogFileParsed = isLogFileParsed;
    }

    @Override
    public void run() {
        while (true) {
            if (isLogFileParsed.get()) {
                threadPool.execute(this::callClient);
                if (claims.isEmpty()) {
                    isLogFileParsed.set(false);
                }
            }
        }
    }

    private void callClient() {
        try {
            LocalDateTime callTime = now();
            ClaimLogFileRow claim = claims.take();
            Thread.sleep(CALLING_TIME);
            writeCallLogFile(callTime, claim);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void writeCallLogFile(LocalDateTime callTime, ClaimLogFileRow claim) {
        try {
            Files.writeString(outputPath, makeCallReport(claim, callTime),
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private CharSequence makeCallReport(ClaimLogFileRow claim, LocalDateTime callTime) {
        return claim.id() + getCommaSpace() +
                callTime.format(DATE_TIME_FORMATTER) +
                getCommaSpace() + claim.phoneNumber() + System.lineSeparator();
    }
}

