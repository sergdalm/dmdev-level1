package com.sergdalm.week7.task.counter.queue;

public class Cashbox {
    private static int generator = 1;
    private final int id;

    public Cashbox() {
        id = generator++;
    }

    @Override
    public String toString() {
        return "Cashbox{" +
                "id=" + id +
                '}';
    }
}
