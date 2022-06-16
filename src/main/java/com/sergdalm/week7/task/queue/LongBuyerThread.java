package com.sergdalm.week7.task.queue;

import java.util.Queue;

public class LongBuyerThread extends BuyerThread {

    public LongBuyerThread(Queue<Cashbox> cashboxes, long waitingTime) {
        super(cashboxes, waitingTime);
    }
}
