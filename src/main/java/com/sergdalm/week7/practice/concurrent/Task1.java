package com.sergdalm.week7.practice.concurrent;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 1. Написать программу, бесконечно считывающую
 * пользовательские числа из консоли.
 * Эти числа представляют собой количество секунд.
 * При каждом вводе числа, должна создаваться задача,
 * которая засыпает на введённое число секунд и затем
 * выводит "Я спал N секунд".
 * Однако нужно сделать так, чтобы все задачи выполнялись в
 * одном и том же потоке в порядке ввода.
 * Т.е. в программе есть 2 потока: главный и поток для
 * выполнения всех задач по очереди.
 * При вводе отрицательного числа программа должна завершать свою работу.
 * Второе решение - несколько потоков в пуле. Посчитать кол-во
 * обработанных задач каждым потоком
 */
public class Task1 {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

        while (scanner.hasNextInt()) {
            int sec = scanner.nextInt();
            if (sec < 0) {
                break;
            }
            executorService.submit(() -> {
                Integer counter = threadLocal.get();
                threadLocal.set(counter == null ? 1 : ++counter);
                System.out.printf("Поток %s, задач %d%n", Thread.currentThread().getName(),
                        threadLocal.get());
                Thread.sleep(sec * 1000L);
                System.out.printf("Поток %s спал %d секунд%n", Thread.currentThread().getName(), sec);
                return sec;
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(1L, TimeUnit.HOURS);
    }
}
