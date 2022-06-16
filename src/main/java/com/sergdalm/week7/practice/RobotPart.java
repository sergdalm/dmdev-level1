package com.sergdalm.week7.practice;

public enum RobotPart {
    HEAD,
    BODY,
    LEFT_HAND,
    RIGHT_HAND,
    LEFT_LEG,
    RIGHT_LEG,
    CPU,
    RAM,
    HDD;

    public static RobotPart getRandomPart() {
        int randomNumber = RandomUtils.getRandom(0, RobotPart.values().length);
        RobotPart[] robotParts = RobotPart.values();
        return robotParts[randomNumber];
    }
}
