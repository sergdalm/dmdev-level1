package com.sergdalm.week7.task.queue;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.stream.Stream;

public class CashboxRunner {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Cashbox> cashboxes = new ArrayBlockingQueue<>(2,true,
                List.of(new Cashbox(), new Cashbox()));

        List<Thread> threads = Stream.of(
                        new BuyerThread(cashboxes),
                        new LongBuyerThread(cashboxes, 5000L),
                        new BuyerThread(cashboxes),
                        new BuyerThread(cashboxes),
                        new BuyerThread(cashboxes),
                        new BuyerThread(cashboxes),
                        new LongBuyerThread(cashboxes, 5000L)
                )
                .map(Thread::new)
                .peek(Thread::start)
                .toList();

        for (Thread thread : threads) {
            thread.join();
        }
    }
}
