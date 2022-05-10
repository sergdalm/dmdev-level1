package com.sergdalm.week1.task.functions;

/**
 * Имеются три числа - день, месяц и год, вводимые пользователем с консоли.
 * Вывести дату следующего дня в формате "День.Месяц.Год".
 * Учесть переход на следующий месяц, а также следующий год.
 * Форматирование строки "День.Месяц.Год" вынести в отдельную функцию.
 */
public class Task1 {
    public static void main(String[] args) {
        printNextDate(29, 2, 2020);
        printNextDate(31, 12, 2022);
    }

    private static void printNextDate(int day, int month, int year) {
        int nextDay = day;
        int monthOfNextDay = month;
        int yearOfNextDay = year;

        if (isDataValid(day, month, year)) {
            if (month == 2) {
                if (year % 4 == 0) {
                    if (day == 29) {
                        nextDay = 1;
                        monthOfNextDay++;
                    } else {
                        nextDay++;
                    }
                } else {
                    if (day == 28) {
                        nextDay = 1;
                        monthOfNextDay++;
                    } else {
                        nextDay++;
                    }
                }
            } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                if (day == 30) {
                    nextDay = 1;
                    monthOfNextDay++;
                }
            } else {
                if (day == 31) {
                    if (month == 12) {
                        nextDay = 1;
                        monthOfNextDay = 1;
                        yearOfNextDay++;
                    } else {
                        nextDay = 1;
                        monthOfNextDay++;
                    }
                } else {
                    nextDay++;
                }
            }
        String nextData = (nextDay > 10 ? nextDay : "0" + nextDay) + "." +
                (monthOfNextDay > 10 ? monthOfNextDay : "0" + monthOfNextDay) + "." + yearOfNextDay;
        System.out.println(nextData);
        }
    }

    private static boolean isDataValid(int day, int month, int year) {
        if (day <= 0 || day > 31 || month <= 0 || month > 12 || year <0) {
            return false;
        }

        if (month == 2) {
            if (year % 4 == 0) {
                return day <= 29;
            } else {
                return day <= 28;
            }
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return day <= 30;
        }
        return true;
    }
}
