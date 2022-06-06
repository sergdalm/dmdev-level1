package com.sergdalm.week5.homework;

public enum Mark {
    F(0),
    E(1),
    D(2),
    C(3),
    B(4),
    A(5);

    private int markNumber;

    Mark(int markNumber) {
        this.markNumber = markNumber;
    }

    public int getMarkNumber() {
        return markNumber;
    }


}
