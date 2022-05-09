package com.sergdalm.week1.homework.functions;

/**
 * В переменной minutes лежит число от 0 до 59.
 * Написать функцию, которая принимает в качестве параметра значение переменной minutes и выводит на консоль
 * в какую четверть часа попадает это число (в первую, вторую, третью или четвертую).
 *
 * Протестировать функцию в main.
 */
public class Task1 {
    public static void main(String[] args) {
        int minutes = 5;
        printPartOfHour(minutes);

        minutes = 20;
        printPartOfHour(minutes);

        minutes = 36;
        printPartOfHour(minutes);

        minutes = 59;
        printPartOfHour(minutes);
    }

    private static void printPartOfHour(int minutes) {
        if(minutes < 0 || minutes > 59) {
            return;
        }

        if (minutes >= 1 && minutes <= 15) {
            System.out.println("This is first quarter of an hour");
        } else if (minutes >= 16 && minutes <= 30) {
            System.out.println("This is second quarter of an hour");
        } else if (minutes >= 31 && minutes <= 45) {
            System.out.println("This is third quarter of an hour");
        } else {
            System.out.println("This is fourth quarter of an hour");
        }
    }
}
