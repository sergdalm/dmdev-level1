package com.sergdalm.week3.homework.space;

public final class SpaceUtils {
    private SpaceUtils() {
    }

    public static boolean isStar(SpaceObject spaceObject) {
        return spaceObject.getCentralObject() == null;
    }

    public static double calculateGravitationalForce(SpaceObject object1, SpaceObject object2) {
        return 6.67 * Math.pow(10, -11) * ((object1.getMass() * object2.getMass()) /
                Math.pow(Math.abs(object1.getDistanceFromStar() - object2.getDistanceFromStar()), 2));
    }
}
