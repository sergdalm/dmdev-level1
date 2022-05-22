package com.sergdalm.week3.homework.space;

public class NaturalSatellite extends Satellite {
    public NaturalSatellite(String name, double mass, SpaceObject centralObject, int distanceFromCentralObject, int radius) {
        super(SpaceObjectType.NATURAL_SATELLITE, name, mass, radius, centralObject, distanceFromCentralObject);
        centralObject.getSatellites().addObject(this);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
