package com.sergdalm.week3.task.encapsulation;

public class Rectangle {
    private Point leftTopCorner;
    private Point rightLowCorner;

    public Rectangle(Point leftTopCorner, Point rightLowCorner) {
        this.leftTopCorner = leftTopCorner;
        this.rightLowCorner = rightLowCorner;
    }

    public Point getLeftTopCorner() {
        return leftTopCorner;
    }

    public Point getRightLowCorner() {
        return rightLowCorner;
    }

    public int getArea() {
        int length = rightLowCorner.distance(new Point(leftTopCorner.getX(), rightLowCorner.getY()));
        int width = rightLowCorner.distance(new Point(rightLowCorner.getX(), leftTopCorner.getY()));
        return length * width;
    }

    public int getDiagonalLength() {
        return rightLowCorner.distance(leftTopCorner);
    }
}
