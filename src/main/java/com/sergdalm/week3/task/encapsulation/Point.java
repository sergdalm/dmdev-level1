package com.sergdalm.week3.task.encapsulation;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int distance(Point other) {
        return (int) Math.sqrt(Math.pow((this.x - other.x), 2) +
                Math.pow((this.y - other.y), 2));
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
