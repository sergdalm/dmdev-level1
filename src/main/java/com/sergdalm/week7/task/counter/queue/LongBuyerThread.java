package com.sergdalm.week7.task.counter.queue;

import java.util.concurrent.BlockingQueue;

public class LongBuyerThread extends BuyerThread {

    public LongBuyerThread(BlockingQueue<Cashbox> cashboxes, long waitingTime) {
        super(cashboxes, waitingTime);
    }
}
