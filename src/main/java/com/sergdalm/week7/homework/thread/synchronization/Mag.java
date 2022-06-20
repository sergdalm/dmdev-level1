package com.sergdalm.week7.homework.thread.synchronization;

import com.sergdalm.week7.homework.model.Crystal;
import com.sergdalm.week7.homework.utril.RandomUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Mag extends Thread {
    private final String name;
    private final Planet planet;
    private int redCristalCount;
    private int whiteCristalCount;
    private boolean isWinner;
    private final Rocket rocket = new Rocket();
    private final int targetAmount;

    public Mag(String name, Planet planet, int targetAmount) {
        this.name = name;
        this.planet = planet;
        this.targetAmount = targetAmount;
    }

    @Override
    public void run() {
        while (planet.isCompetitionGoing()) {
            synchronized (planet.getLock()) {
                rocket.flyToPlanet();
                receiveCrystalsFromRocket();
                if (redCristalCount >= targetAmount && whiteCristalCount >= targetAmount) {
                    isWinner = true;
                    planet.stopCompetition();
                }
                waitNextMidnight();
            }
        }
    }

    private void waitNextMidnight() {
        try {
            planet.getLock().wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void receiveCrystalsFromRocket() {
        Iterator<Crystal> iterator = rocket.crystals.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(Crystal.RED_CRYSTAL)) {
                redCristalCount++;
            } else {
                whiteCristalCount++;
            }
            iterator.remove();
        }
        printStatistics();
    }

    public void printStatistics() {
        System.out.printf("%s collected %d red crystals and %d white crystals\n",
                name, redCristalCount, whiteCristalCount);
    }

    public String getMagName() {
        return name;
    }

    public boolean isWinner() {
        return isWinner;
    }

    private class Rocket {
        private final List<Crystal> crystals = new ArrayList<>();

        public void flyToPlanet() {
            synchronized (planet.getCrystals()) {
                int randomAmount = RandomUtil.getRandomFromTwoToFive();
                Iterator<Crystal> iterator = planet.getCrystals().iterator();
                while (iterator.hasNext() && randomAmount > 0) {
                    crystals.add(iterator.next());
                    iterator.remove();
                    randomAmount--;
                }
            }

            System.out.println(Mag.this.name + "'s rocket brought " + crystals);
        }


    }
}
