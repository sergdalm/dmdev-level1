package com.sergdalm.week2.homework.oop;

/**
 * Представить в виде классов и их композиции следующую модель.
 * - Каждый дом содержит свой номер (int), и множество этажей (массив).
 * - Каждый этаж содержит номер этажа (int), и множество квартир (массив).
 * - Каждая квартира содержит свой номер (int), и множество комнат (массив).
 * - Каждая комната содержит поле проходная она или нет (boolean).
 * В каждом классе реализовать метод print, который на консоль выводит информацию
 * об объекте (должны присутствовать все поля объекта!).
 * <p>
 * Например, метод print класса этаж должен выводить на консоль:
 * “Этаж 2, количество квартир 18”
 * Создание всех объектов вынести в отдельный класс с методом main.
 * Там же реализовать метод printAllInformation, который на вход принимает объект
 * типа дом, и выводит информацию о нем, его этажах, квартирах и комнатах,
 * вызывая методы print.
 */
public class Task1Demo {

    public static void main(String[] args) {
        int amountOfHouses = 3;
        int amountOfFloorsInHouse = 3;
        int amountOfFlatsOnFloor = 4;
        int amountOfNotPassageRoomsInFlat = 3;
        int amountOfPassageRoomsInFlat = 1;
        int amountOfRoomsInFlat = amountOfNotPassageRoomsInFlat + amountOfPassageRoomsInFlat;

        House[] houses = new House[amountOfHouses];

        for (int i = 0; i < amountOfHouses; i++) {
            houses[i] = new House(i + 1, new Floor[amountOfFloorsInHouse]);
            for (int j = 0; j < amountOfFloorsInHouse; j++) {
                houses[i].getFloors()[j] = new Floor(j + 1, new Flat[amountOfFlatsOnFloor]);
                for (int k = 0; k < amountOfFlatsOnFloor; k++) {
                    houses[i].getFloors()[j].getFlats()[k] = new Flat(k + 1, new Room[amountOfRoomsInFlat]);
                    for (int l = 0; l < amountOfRoomsInFlat; l++) {
                        if (l == amountOfPassageRoomsInFlat) {
                            houses[i].getFloors()[j].getFlats()[k].getRooms()[l] = new Room(l + 1, true);
                        } else {
                            houses[i].getFloors()[j].getFlats()[k].getRooms()[l] = new Room(l + 1, false);
                        }
                    }
                }
            }
        }

        houses[0].getFloors()[0].print();
        houses[1].getFloors()[2].getFlats()[1].print();
        houses[2].getFloors()[1].getFlats()[1].getRooms()[2].print();
        houses[0].printAllInformation();
    }
}
