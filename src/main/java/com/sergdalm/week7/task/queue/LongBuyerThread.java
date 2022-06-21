package com.sergdalm.week7.task.queue;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;

public class LongBuyerThread extends BuyerThread {

    public LongBuyerThread(BlockingQueue<Cashbox> cashboxes, long waitingTime) {
        super(cashboxes, waitingTime);
    }
}
