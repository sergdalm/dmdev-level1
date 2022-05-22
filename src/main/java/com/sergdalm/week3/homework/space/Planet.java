package com.sergdalm.week3.homework.space;

public class Planet extends SpaceObject {
    private final boolean hasRing;

    public Planet(String name, double mass, SpaceObject centralObject, int distanceFromCentralObject, int radius, boolean hasRing) {
        super(SpaceObjectType.PLANET, name, mass, centralObject, distanceFromCentralObject, radius);
        this.hasRing = hasRing;
        centralObject.getSatellites().addObject(this);
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n  " + this.getName() + (hasRing ? " has a ring" : " doesn't have a ring");
    }
}
