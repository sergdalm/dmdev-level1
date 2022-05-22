package com.sergdalm.week3.homework.space;

public class ArtificialSatellite extends Satellite implements ArtificialObject {
    private final SpaceObject creator;
    private final int creationYear;

    public ArtificialSatellite(String name, double mass, SpaceObject centralObject,
                               int distanceFromCentralObject, int radius, SpaceObject creator, int creationYear) {
        super(SpaceObjectType.ARTIFICIAL_SATELLITE, name, mass, radius, centralObject, distanceFromCentralObject);
        this.creator = creator;
        this.creationYear = creationYear;
        centralObject.getSatellites().addObject(this);
    }

    @Override
    public boolean sendStatistics() {
        System.out.println("Artificial satellite " + this.getName() + " is sending statistics to " + creator.getName());
        return false;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n  created on: " + creator.getName() +
                "\n  year of creation: " + creationYear;
    }
}
