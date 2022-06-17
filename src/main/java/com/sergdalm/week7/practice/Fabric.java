package com.sergdalm.week7.practice;

import java.util.List;

public class Fabric implements Runnable {
    private final Night night;
    private final List<RobotPart> dump;

    public Fabric(List<RobotPart> dump, Night night) {
        this.dump = dump;
        this.night = night;
    }

    @Override
    public void run() {
        for (int i = 0; i < night.getAmountOfNights(); i++) {
            addRobotPartsToDamp(i);
            waitNextNight();
        }
    }

    private void addRobotPartsToDamp(int i) {
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
        }
    }

    private void waitNextNight() {
        synchronized (night.getLock()) {
            try {
                night.getLock().wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
