package com.sergdalm.week3.homework.space;

public class SpaceObjectList implements MyList {
    private final int DEFAULT_CAPACITY = 10;
    private final double FILL_RATIO = 0.75;
    private int capacity;
    private int size;
    private SpaceObject[] spaceObjects;

    public SpaceObjectList() {
        spaceObjects = new SpaceObject[DEFAULT_CAPACITY];
        capacity = DEFAULT_CAPACITY;
        size = 0;
    }

    public SpaceObjectList(int initialCapacity) {
        if (initialCapacity < DEFAULT_CAPACITY) {
            spaceObjects = new SpaceObject[DEFAULT_CAPACITY];
            this.capacity = DEFAULT_CAPACITY;
        } else {
            spaceObjects = new SpaceObject[capacity];
            this.capacity = initialCapacity;
        }
        size = 0;
    }

    @Override
    public SpaceObject addObject(SpaceObject spaceObject) {
        if ((capacity - (size + 1)) / (double) capacity >= FILL_RATIO) {
            spaceObjects = grow();
        }
        spaceObjects[size++] = spaceObject;
        return spaceObject;
    }

    private SpaceObject[] grow() {
        int newCapacity = capacity + (capacity / 2);
        SpaceObject[] newSpaceObjectsArray = new SpaceObject[newCapacity];
        for (int i = 0; i < size; i++) {
            newSpaceObjectsArray[i] = spaceObjects[i];
        }
        return newSpaceObjectsArray;
    }

    @Override
    public SpaceObject removeObject(SpaceObject spaceObject) {
        int index = getIndex(spaceObject);
        if (index == -1) {
            return null;
        }
        int i;
        for (i = index; i < size; i++) {
            spaceObjects[i] = spaceObjects[i + 1];
        }
        spaceObjects[i + 1] = null;
        size--;
        return spaceObject;
    }

    private int getIndex(SpaceObject spaceObject) {
        for (int i = 0; i < size; i++) {
            if (spaceObjects[i] == spaceObject)
                return i;
        }
        return -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            stringBuilder.append(spaceObjects[i].getName());
            if (i != (size - 1)) {
                stringBuilder.append(", ");
            }
        }
        return stringBuilder.toString();
    }

    public int size() {
        return size;
    }
}
