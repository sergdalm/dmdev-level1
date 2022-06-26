package com.sergdalm.week8.homework.runnable;

import com.sergdalm.week8.homework.dto.Citizen;
import com.sergdalm.week8.homework.util.RandomUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static com.sergdalm.week8.homework.util.DelimiterUtil.getCommaSpace;

public class ClaimFactory implements Runnable {
    private static final Path CITIZENS_FILE = Path.of("src", "main", "resources", "claim", "citizens.txt");
    private static final Path CLAIMS_FILE = Path.of("src", "main", "resources", "claim", "claims.txt");
    private static final long TIMEOUT = 5000L;
    private static final String CITIZEN_REGEX = "^(?<id>\\d+), (?<name>[А-Яа-яЁё]+ [А-Яа-яЁё]+), (?<number>.*)";
    private static final Pattern CITIZEN_PATTERN = Pattern.compile(CITIZEN_REGEX);
    private static final String ID_GROUP = "id";
    private static final String NAME_GROUP = "name";
    private static final String NUMBER_GROUP = "number";
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
    private static final List<Citizen> CITIZEN_LIST = new ArrayList<>();
    private static final List<String> CLAIMS_LIST = new ArrayList<>();
    private final Path claimLogFile;

    // Put all citizens and claims into collections
    static {
        try (Stream<String> citizensLines = Files.lines(CITIZENS_FILE);
             Stream<String> claimsLines = Files.lines(CLAIMS_FILE)) {
            citizensLines.map(CITIZEN_PATTERN::matcher)
                    .filter(Matcher::find)
                    .forEach(matcher -> CITIZEN_LIST.add(new Citizen(
                            Integer.parseInt(matcher.group(ID_GROUP)),
                            matcher.group(NAME_GROUP),
                            matcher.group(NUMBER_GROUP))));

            claimsLines.forEach(CLAIMS_LIST::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ClaimFactory(Path claimLogFile) {
        this.claimLogFile = claimLogFile;
    }

    @Override
    public void run() {
        while (true) {
            int randomCitizenIndex = RandomUtil.getRandom(CITIZEN_LIST.size());
            int randomClaimIndex = RandomUtil.getRandom(CLAIMS_LIST.size());
            String claim = makeClaim(randomCitizenIndex, randomClaimIndex);
            writeClaim(claim);
            takeTimeout();
        }
    }

    private void takeTimeout() {
        try {
            Thread.sleep(TIMEOUT);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private String makeClaim(int randomCitizenIndex, int randomClaimIndex) {
        return System.lineSeparator() + CITIZEN_LIST.get(randomCitizenIndex).id() +
                getCommaSpace() + LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS).format(DATE_TIME_FORMATTER) +
                getCommaSpace() + CITIZEN_LIST.get(randomCitizenIndex).name() +
                getCommaSpace() + CITIZEN_LIST.get(randomCitizenIndex).number() +
                getCommaSpace() + CLAIMS_LIST.get(randomClaimIndex);
    }

    private void writeClaim(String claim) {
        try {
            Files.write(claimLogFile, claim.getBytes(), StandardOpenOption.WRITE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
