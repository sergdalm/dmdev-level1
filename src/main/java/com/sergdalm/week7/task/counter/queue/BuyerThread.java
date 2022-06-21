package com.sergdalm.week7.task.counter.queue;

import java.util.concurrent.BlockingQueue;

public class BuyerThread implements Runnable {
    private final long waitingTime;

    private final BlockingQueue<Cashbox> cashboxes;

    public BuyerThread(BlockingQueue<Cashbox> cashboxes) {
        this.cashboxes = cashboxes;
        waitingTime = 5L;
    }

    public BuyerThread(BlockingQueue<Cashbox> cashboxes, long waitingTime) {
        this.waitingTime = waitingTime;
        this.cashboxes = cashboxes;
    }

    @Override
    public void run() {
        // По-хорошему надо возвращать cashbox в блоке finally
        // если кто-то прервал наш поток, но для демонстрации можно и без него.
        try {
            Cashbox cashbox = cashboxes.take();
            System.out.println(Thread.currentThread().getName() + (waitingTime > 5L ? " (ТОРМОЗ)" : "") + " обсуживается в кассе " + cashbox);
            Thread.sleep(waitingTime);
            cashboxes.add(cashbox);
            System.out.println(Thread.currentThread().getName() + " освобождаю кассу " + cashbox);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
