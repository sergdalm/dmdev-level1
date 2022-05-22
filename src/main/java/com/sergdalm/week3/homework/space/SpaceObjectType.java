package com.sergdalm.week3.homework.space;

public enum SpaceObjectType {
    STAR("Star"),
    PLANET("Planet"),
    NATURAL_SATELLITE("Natural satellite"),
    ARTIFICIAL_SATELLITE("Artificial satellite");

    private final String name;

    SpaceObjectType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
