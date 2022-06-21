package com.sergdalm.week7.task.counter.queue.semaphore;


import java.util.concurrent.Semaphore;

public class BuyerThread implements Runnable {
    private final long waitingTime;

    private final Semaphore cashboxes;

    public BuyerThread(Semaphore cashboxes) {
        this.cashboxes = cashboxes;
        waitingTime = 5L;
    }

    @Override
    public void run() {
        try {
            cashboxes.acquire();
            System.out.println(Thread.currentThread().getName() + " обсуживается в какой-то кассе");
            Thread.sleep(waitingTime);
            System.out.println(Thread.currentThread().getName() + " освобождаю какую-то кассу");
            cashboxes.release();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
