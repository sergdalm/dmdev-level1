package com.sergdalm.week7.task;

public class SimpleRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello from runnable: " + Thread.currentThread().getName());
    }
}
