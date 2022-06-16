package com.sergdalm.week7.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RobotMakerRunner {
    public static void main(String[] args) {
        int days = 100;
        List<RobotPart> dump = Collections.synchronizedList(new ArrayList<>());
        Scientist scientist1 = new Scientist("scientist 1", days, dump);
        Scientist scientist2 = new Scientist("scientist 2", days, dump);
        Thread scientistThread1 = new Thread(scientist1);
        Thread scientistThread2 = new Thread(scientist2);


        Thread fabric = new Thread(new Fabric(dump, days));

        fabric.start();
        scientistThread1.start();
        scientistThread2.start();

        try {
            fabric.join();
            scientistThread1.join();
            scientistThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
