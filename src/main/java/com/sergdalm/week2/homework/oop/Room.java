package com.sergdalm.week2.homework.oop;

public class Room {
    private final int number;
    private final boolean isPassage;

    public Room(int number, boolean isPassage) {
        this.number = number;
        this.isPassage = isPassage;
    }

    public void print() {
        System.out.println("Room No. " + number +
                (isPassage ? " (passage room)" : " (not passage room)"));
    }
}
