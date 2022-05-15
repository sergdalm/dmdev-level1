package com.sergdalm.week2.homework.oop;

public class House {
    private final int number;
    private final Floor[] floors;

    public House(int number, Floor[] floor) {
        this.number = number;
        this.floors = floor;
    }

    public void print() {
        System.out.println("House No. " + number + ", amount of floors: " + floors.length);
    }

    public void printAllInformation() {
        System.out.println("House No. " + number);
        for (Floor floor : floors) {
            System.out.print("  ");
            floor.print();
            for (int j = 0; j < floor.getFlats().length; j++) {
                System.out.print("    ");
                floor.getFlats()[j].print();
                for (int k = 0; k < floor.getFlats()[j].getRooms().length; k++) {
                    System.out.print("      ");
                    floor.getFlats()[j].getRooms()[k].print();
                }
            }
        }
    }

    public Floor[] getFloors() {
        return floors;
    }
}
