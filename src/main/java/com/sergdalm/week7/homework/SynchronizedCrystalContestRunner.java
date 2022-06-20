package com.sergdalm.week7.homework;

import com.sergdalm.week7.homework.thread.synchronization.Mag;
import com.sergdalm.week7.homework.thread.synchronization.Planet;
import com.sergdalm.week7.homework.utril.ThreadUtils;

public class SynchronizedCrystalContestRunner {

    public static void main(String[] args) {
        int targetCrystalAmount = 500;
        int dayLength = 50;
        Planet planet = new Planet(dayLength);
        Mag fireMag = new Mag("Fire mag", planet, targetCrystalAmount);
        Mag airMag = new Mag("Air mag", planet, targetCrystalAmount);

        ThreadUtils.startThreads(planet, fireMag, airMag);
        ThreadUtils.joinThreads(planet, fireMag, airMag);


        System.out.println("-------The end-------");
        if (fireMag.isWinner()) {
            System.out.println(fireMag.getMagName() + " won!");
            fireMag.printStatistics();
        } else {
            System.out.println(airMag.getMagName() + " won!");
            airMag.printStatistics();
        }
    }
}
