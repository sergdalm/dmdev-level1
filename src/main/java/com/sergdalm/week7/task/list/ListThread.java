package com.sergdalm.week7.task.list;

import java.util.List;

public class ListThread extends Thread {
    private final List<Integer> list;

    public ListThread(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            //synchronized (list) {
            list.add(i);
            //}
        }
    }
}
