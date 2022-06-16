package com.sergdalm.week7.task.producer;

import java.util.List;

public class ConsumerThread extends Thread {
    private final List<Integer> integers;

    public ConsumerThread(List<Integer> integers) {
        this.integers = integers;
    }

    @Override
    public void run() {
        synchronized (integers) {
            while (true) {
                if (!integers.isEmpty()) {
                    Integer integer = integers.remove(0);
                    System.out.println("Got integer " + integer + " (size of LinkedList is " + integers.size() + ")");
                } else {
                    System.out.println("Consumer is waiting, list is empty");
                }
                try {
                    int waitingTime = 80;
                    System.out.println("Consumer waits: " + waitingTime);
                    integers.wait(waitingTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
