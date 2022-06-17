package com.sergdalm.week7.practice;

public class Night implements Runnable {
    private final Object lock = new Object();
    private final int AMOUNT_OF_NIGHTS;
    private final int WAITING_TIME;

    public Night(int AMOUNT_OF_NIGHTS, int WAITING_TIME) {
        this.AMOUNT_OF_NIGHTS = AMOUNT_OF_NIGHTS;
        this.WAITING_TIME = WAITING_TIME;
    }

    @Override
    public void run() {
        synchronized (lock) {
            for (int i = 0; i < AMOUNT_OF_NIGHTS; i++) {
                System.out.println("----------------------");
                System.out.println("Night no. " + (i + 1));
                lock.notifyAll();
                try {
                    lock.wait(WAITING_TIME);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Object getLock() {
        return lock;
    }

    public int getAmountOfNights() {
        return AMOUNT_OF_NIGHTS;
    }

    public int getWaitingTime() {
        return WAITING_TIME;
    }
}
