package com.sergdalm.week7.task.queue;

import java.util.Queue;

public class BuyerThread implements Runnable {
    private final long waitingTime;

    private final Queue<Cashbox> cashboxes;

    public BuyerThread(Queue<Cashbox> cashboxes) {
        this.cashboxes = cashboxes;
        waitingTime = 5L;
    }

    public BuyerThread(Queue<Cashbox> cashboxes, long waitingTime) {
        this.waitingTime = waitingTime;
        this.cashboxes = cashboxes;
    }

    @Override
    public void run() {
        try {
            synchronized (cashboxes) {
                while (true) {
                    if (!cashboxes.isEmpty()) {
                        Cashbox cashbox = cashboxes.remove();
                        System.out.println(Thread.currentThread().getName() + (waitingTime > 5L ? " (ТОРМОЗ)" : "") + " обсуживается в кассе " + cashbox);

                        cashboxes.wait(waitingTime);

                        System.out.println(Thread.currentThread().getName() + " освобождаю кассу " + cashbox);
                        cashboxes.add(cashbox);
                        cashboxes.notifyAll();
                        break;
                    } else {
                        System.out.println(Thread.currentThread().getName() + " ожидает свободную кассу");
                        cashboxes.wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
