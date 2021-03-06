package com.sergdalm.week7.practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Scientist implements Runnable {
    private final String name;
    private final Night night;
    List<RobotPart> allRobotParts = new ArrayList<>();
    Set<RobotPart> partsForOneRobot = new HashSet<>();
    List<Robot> robots = new ArrayList<>();
    private final Servant servant;

    public Scientist(String name, List<RobotPart> dump, Night night) {
        this.name = name;
        servant = new Servant(dump);
        this.night = night;
    }

    @Override
    public void run() {
        for (int i = 0; i < night.getAmountOfNights(); i++) {
            servant.getDetail();
            if (partsForOneRobot.size() == RobotPart.values().length) {
                makeRobot();
            }
            waitForNextNight();
        }

        System.out.println(name + " made " + robots.size() + " robots");
        System.out.println(name + "'s robot pats: " + partsForOneRobot + ", " + allRobotParts);
    }

    private void waitForNextNight() {
        synchronized (night.getLock()) {
            try {
                night.getLock().wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void makeRobot() {
        Robot.makeRobot(partsForOneRobot)
                .ifPresent(robot -> {
                    robots.add(robot);
                    System.out.println(name + " made one robot!");
                    System.out.println("Total amount of robots: " + robots.size());
                });

        Iterator<RobotPart> iterator = allRobotParts.iterator();
        while (iterator.hasNext()) {
            RobotPart part = iterator.next();
            if (!partsForOneRobot.contains(part)) {
                partsForOneRobot.add(part);
                iterator.remove();
            }
        }
    }

    public void getElement(RobotPart robotPart) {
        System.out.println(name + " got " + robotPart + " from his servant");
        if (partsForOneRobot.contains(robotPart)) {
            allRobotParts.add(robotPart);
        } else {
            partsForOneRobot.add(robotPart);
        }
    }

    public String getName() {
        return name;
    }

    public class Servant {
        List<RobotPart> robotParts = new ArrayList<>();
        final List<RobotPart> dump;

        public Servant(List<RobotPart> dump) {
            this.dump = dump;
        }

        public void getDetail() {
            synchronized (dump) {
                while (!dump.isEmpty()) {
                    RobotPart part = dump.remove(0);
                    robotParts.add(part);
                    try {
                        dump.wait(1L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("Servant of " + Scientist.this.name + " found " + robotParts);
                if (!robotParts.isEmpty()) {
                    Iterator<RobotPart> iterator = robotParts.iterator();
                    while (iterator.hasNext()) {
                        RobotPart part = iterator.next();
                        Scientist.this.getElement(part);
                        iterator.remove();
                    }
                }
            }
        }
    }
}
