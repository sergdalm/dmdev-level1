package com.sergdalm.week7.task.cuncurrent.pool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(4);
        threadPool.scheduleAtFixedRate(() -> System.out.println("OK"), 2L, 4L, TimeUnit.SECONDS);
        //threadPool.shutdown();
        //threadPool.awaitTermination(1L, TimeUnit.HOURS);
        Thread.sleep(10L);
    }

    private static void test() throws InterruptedException, ExecutionException {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        Future<Integer> future = threadPool.submit(() -> {
            Thread.sleep(10000L);
            System.out.println("It's callable");
            return 1;
        });

        //System.out.println("Result: " + future.get());
        threadPool.shutdown();
        //threadPool.awaitTermination(1L, TimeUnit.SECONDS);
        System.out.println("main end");
    }
}
