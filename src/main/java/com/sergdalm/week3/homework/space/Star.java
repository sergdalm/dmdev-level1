package com.sergdalm.week3.homework.space;

public class Star extends SpaceObject {
    private final int temperature;

    public Star(String name, double mass, int temperature, int radius) {
        super(SpaceObjectType.STAR, name, mass, null, 0, radius);
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n  temperature: " + temperature;
    }
}
