package com.sergdalm.week7.task;

public class ThreadDemo {
    public static void main(String[] args) {
        var simpleThread = new SimpleThread();
        System.out.println(simpleThread.getName() + ": " + simpleThread.getState());
        var runnableThread = new Thread(new SimpleRunnable(), "Runnable name");
        var lambdaThread = new Thread(() -> System.out.println("Hello from lambda " + Thread.currentThread().getName()));

        simpleThread.start();
        runnableThread.start();
        lambdaThread.start();
        System.out.println(simpleThread.getName() + ": " + simpleThread.getState());

        try {
            simpleThread.join(100L);
            runnableThread.join();
            lambdaThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(simpleThread.getName() + ": " + simpleThread.getState());
        System.out.println(Thread.currentThread().getName());
    }
}
