package com.sergdalm.week3.practice.enummerations;

import java.util.Arrays;
import java.util.Scanner;

public class EnumDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter day of week:");
        String day = scanner.nextLine();

        switch (WeekDays.valueOf(day)) {
            case MONDAY -> System.out.println("This is MONDAY");
            case TUESDAY -> System.out.println("This is TUESDAY");
            case WEDNESDAY -> System.out.println("This is WEDNESDAY");
            case THURSDAY -> System.out.println("This is THURSDAY");
            case FRIDAY -> System.out.println("This is FRIDAY");
            case SATURDAY -> System.out.println("This is SATURDAY");
            case SUNDAY -> System.out.println("This is SUNDAY");
            default -> System.out.println("There is no such day in week as " + day);
        }

        for (WeekDays weekDay : WeekDays.values()) {
            System.out.println(weekDay.ordinal());
        }

        System.out.println(Arrays.toString(WeekDays.values()));


    }
}
