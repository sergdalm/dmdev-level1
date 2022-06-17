package com.sergdalm.week7.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RobotMakerRunner {
    public static void main(String[] args) {
        Night night = new Night(100, 100);
        List<RobotPart> dump = Collections.synchronizedList(new ArrayList<>());
        Thread fabric = new Thread(new Fabric(dump, night));
        Scientist scientist1 = new Scientist("scientist 1", dump, night);
        Scientist scientist2 = new Scientist("scientist 2", dump, night);
        Thread scientistThread1 = new Thread(scientist1);
        Thread scientistThread2 = new Thread(scientist2);



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
