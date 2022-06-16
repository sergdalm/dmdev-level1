package com.sergdalm.week7.practice;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class Robot {
    private Robot() {
    }

    public static Optional<Robot> makeRobot(Set<RobotPart> robotParts) {
        if (robotParts.size() == RobotPart.values().length) {
            List.of(RobotPart.values()).forEach(robotParts::remove);
            return Optional.of(new Robot());
        } else {
            System.out.println("Not enough details");
            return Optional.empty();
        }
    }
}
