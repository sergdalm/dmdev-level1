package com.sergdalm.week8.task;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternFindExample {

    public static void main(String[] args) {
        String phoneNumber = "fgfg +375 (33) 898-12-55 dfbfbfbdfbfd +375 (29) 357-12-15 klfkfjffjkjf " +
                "fdf +375 (44) 777-12-88 dsdsdffsdvd +375 (25) 111-12-25 ffdf";
        String regex = "(?:\\+375)? ?\\((?<code>\\d{2})\\) ?(\\d{3})-(\\d{2})-(\\d{2})";

        // Замена подстроки вариант 1
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        StringBuilder stringBuilder = new StringBuilder();

        while (matcher.find()) {
            matcher.appendReplacement(stringBuilder, "$2 - $3 - $4");
        }
        matcher.appendTail(stringBuilder);
        System.out.println(stringBuilder);

        // Замена подстроки вариант 1
        System.out.println(phoneNumber.replaceAll(regex, "$2 - $3 - $4"));
    }
}
