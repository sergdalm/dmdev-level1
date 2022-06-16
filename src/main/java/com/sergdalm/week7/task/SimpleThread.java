package com.sergdalm.week7.task;

public class SimpleThread extends Thread {
    @Override
    public void run() {
        System.out.println("Hello " + getName());
    }
}
