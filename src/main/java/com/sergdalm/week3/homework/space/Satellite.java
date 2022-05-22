package com.sergdalm.week3.homework.space;

public abstract class Satellite extends SpaceObject {

    public Satellite(SpaceObjectType type, String name, double mass, int radius, SpaceObject centralObject, int distanceFromCentralObject) {
        super(type, name, mass, centralObject, distanceFromCentralObject, radius);
    }

}
