package com.sergdalm.week7.task.producer;

import java.util.LinkedList;
import java.util.List;

/**
 * Задан LinkedList, представляющий собой хранилище целых чисел.
 * Поток ProducerThread c какой-то периодичностью бесконечно
 * добавляет в этот список случайные числа,
 * однако максимальное количество, которое он может
 * добавить, равно 10.
 * <p>
 * Поток ConsumerThread бесконечно считывает числа с какой-то случайной
 * задержкой (от 0 до 10 мс).
 * <p>
 * Сделать так, чтобы метод produce добавлял числа только тогда,
 * когда не превышен лимит, а метод consume забирал их только
 * тогда, когда в списке что-нибудь есть.
 * При этом методы должны корректно работать в многопоточной
 * среде.
 * <p>
 * Создать и запустить два различных потока, один из которых
 * вызывает produce, а другой - consume.
 * Продемонстрировать корректность работы хранилища с помощью
 * вывода сообщений в консоль о добавлении, получении и текущем
 * размере хранилища на этапах добавления и получения.
 */
public class TaskDemo {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> integers = new LinkedList<>();

        ProducerThread producerThread = new ProducerThread(integers);
        ConsumerThread consumerThread = new ConsumerThread(integers);

        producerThread.start();
        consumerThread.start();

        producerThread.join();
        consumerThread.join();

    }
}
