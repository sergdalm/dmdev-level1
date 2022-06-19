package com.sergdalm.week7.homework.thread.synchronization;

import com.sergdalm.week7.homework.model.Crystal;
import com.sergdalm.week7.homework.utril.RandomUtil;

import java.util.LinkedList;
import java.util.List;

public class Planet extends Thread {
    private final int lengthOfDay;
    private final Object lock = new Object();
    private final List<Crystal> crystals = new LinkedList<>();
    private volatile boolean isCompetitionGoing = true;

    public Planet(int lengthOfDay) {
        this.lengthOfDay = lengthOfDay;
    }

    @Override
    public void run() {
        while (isCompetitionGoing) {
            synchronized (lock) {
                System.out.println("-----------------------");
                System.out.println("Midnight struck");
                growCrystals();
                lock.notifyAll();
                try {
                    System.out.println("(day goes..");
                    lock.wait(lengthOfDay);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        synchronized (lock) {
            lock.notifyAll();
        }

    }

    private void growCrystals() {
        int randomAmount = RandomUtil.getRandomFromTwoToFive();
        synchronized (crystals) {
            for (int i = 0; i < randomAmount; i++) {
                crystals.add(Crystal.getRandomCrystal());
            }
            System.out.println("Today on planet have grown " + crystals);
        }
    }


    public void stopCompetition() {
        isCompetitionGoing = false;
    }

    public boolean isCompetitionGoing() {
        return isCompetitionGoing;
    }

    public Object getLock() {
        return lock;
    }

    public List<Crystal> getCrystals() {
        return crystals;
    }
}
