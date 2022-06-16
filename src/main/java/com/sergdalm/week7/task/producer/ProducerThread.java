package com.sergdalm.week7.task.producer;

import java.util.List;

public class ProducerThread extends Thread {
    private final List<Integer> integers;

    public ProducerThread(List<Integer> integers) {
        this.integers = integers;
    }

    @Override
    public void run() {
        synchronized (integers) {
            while (true) {
                if (integers.size() < 10) {
                    int randomInteger = RandomUtils.getRandom();
                    integers.add(randomInteger);
                    System.out.println("Put integer " + randomInteger + " (size of LinkedList is " + integers.size() + ")");
                    try {
                        integers.wait(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Producer does nothing");
                }
                try {
                    int waitingTime = 20;
                    System.out.println("Producer waits: " + waitingTime);
                    integers.wait(waitingTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
