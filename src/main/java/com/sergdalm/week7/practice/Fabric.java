package com.sergdalm.week7.practice;

import java.util.List;

public class Fabric implements Runnable {
    private final int NIGHT_WAITING = 100;
    private final int amountOfDays;
    private final List<RobotPart> dump;

    public Fabric(List<RobotPart> dump, int amountOfDays) {
        this.dump = dump;
        this.amountOfDays = amountOfDays;
    }

    @Override
    public void run() {
        for (int i = 0; i < amountOfDays; i++) {
            synchronized (dump) {
                int randomNumber;
                if (i == 0) {
                    randomNumber = 20;
                } else {
                    randomNumber = RandomUtils.getRandom();
                }
                for (int j = 0; j < randomNumber; j++) {
                    RobotPart randomPart = RobotPart.getRandomPart();
                    dump.add(randomPart);
                    System.out.println("Fabric throw out " + randomPart + " at dump");
                }
                try {
                    dump.wait(NIGHT_WAITING);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
