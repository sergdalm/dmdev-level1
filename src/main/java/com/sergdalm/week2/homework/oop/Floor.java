package com.sergdalm.week2.homework.oop;

public class Floor {
    private final int number;
    private final Flat[] flats;

    public Floor(int number, Flat[] flats) {
        this.number = number;
        this.flats = flats;
    }

    public void print() {
        System.out.println("Floor No. " + number + ", amount of flats: " + flats.length);
    }

    public Flat[] getFlats() {
        return flats;
    }
}
