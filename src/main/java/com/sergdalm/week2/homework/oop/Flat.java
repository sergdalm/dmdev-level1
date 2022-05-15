package com.sergdalm.week2.homework.oop;

public class Flat {
    private final int number;
    private final Room[] rooms;

    public Flat(int number, Room[] rooms) {
        this.number = number;
        this.rooms = rooms;
    }

    public void print() {
        System.out.println("Flat No. " + number + ", amount of rooms: " + rooms.length);
    }

    public Room[] getRooms() {
        return rooms;
    }
}
