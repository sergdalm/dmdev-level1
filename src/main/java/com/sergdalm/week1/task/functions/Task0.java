package com.sergdalm.week1.task.functions;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Имеется дата в формате "День.Месяц.Год", вводимая пользователем с консоли.
 * Вывести дату следующего дня в формате "День.Месяц.Год".
 */
public class Task0 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input date in format DD.MM.YYYY and press 'Enter':");
        String input;
        do {
            input = scanner.nextLine();
        } while (!dateVerification(input));

        System.out.println("Next day: " + getNextDay(input));
    }


    public static String getNextDay(String date) {
        String[] dateAsStringArray = date.split("\\.");
        int day = Integer.parseInt(dateAsStringArray[0]);
        int month = Integer.parseInt(dateAsStringArray[1]);
        int year = Integer.parseInt(dateAsStringArray[2]);
        int nextDay = day;
        int monthOfNextDay = month;
        int yearOfNextDay = year;

        // Check if year is leap year
        if (month == 2) {
            if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
                if (day >= 29) {
                    nextDay = 1;
                    monthOfNextDay++;
                } else {
                    nextDay++;
                }
            } else {
                if (day >= 28) {
                    nextDay = 1;
                    monthOfNextDay++;
                } else {
                    nextDay++;
                }
            }

        } else if (month >= 12) {
            if (day >= 31) {
                nextDay = 1;
                monthOfNextDay = 1;
                yearOfNextDay++;
            }
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            if (day >= 30) {
                nextDay = 1;
                monthOfNextDay++;
            }
        } else {
            if (day >= 31) {
                nextDay = 1;
                monthOfNextDay++;
            } else {
                nextDay++;
            }
        }

        return (nextDay > 10 ? nextDay : "0" + nextDay) + "." +
                (monthOfNextDay > 10 ? monthOfNextDay : "0" + monthOfNextDay) + "." + yearOfNextDay;
    }

    // Check if the date matches required format
    public static boolean dateVerification(String date) {
        try {
            Pattern pattern = Pattern.compile("(?<day>\\d{2})\\.(?<month>\\d{2})\\.(\\d+$)");
            Matcher matcher = pattern.matcher(date);
            if (!matcher.matches()) {
                return false;
            }
            int day = Integer.parseInt(matcher.group("day"));
            int month = Integer.parseInt(matcher.group("month"));

            if (day <= 0 || month <= 0 || month > 12 || day > 31) {
                return false;
            }

        } catch (Exception exc) {
            return false;
        }

        return true;
    }
}

