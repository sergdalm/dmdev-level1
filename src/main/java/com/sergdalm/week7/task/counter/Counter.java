package com.sergdalm.week7.task.counter;

public class Counter {
    private int counter;
    private static String description;

    public static void init() {
        Class<Counter> counterClass = Counter.class;
        synchronized (counterClass) {
            if (description == null) {
                description = "Test description";
            }
        }
    }

    public void increment() {
        synchronized (this) {
            counter++;
        }
    }

    public synchronized void decrement() {
        counter--;
    }

    public int getCount() {
        return counter;
    }
}
