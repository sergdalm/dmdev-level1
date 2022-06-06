package com.sergdalm.week5.homework;

public enum YearOfUniversity {
    FIRST(1, "first-year"),
    SECOND(2, "second-year"),
    THIRD(3, "third-year"),
    FOURTH(4, "fourth-year");
    private int numberOfYear;
    private String nameOfYear;


    YearOfUniversity(int numberOfYear, String nameOfYear) {
        this.numberOfYear = numberOfYear;
        this.nameOfYear = nameOfYear;
    }

    public int getNumberOfYear() {
        return numberOfYear;
    }

    public String getNameOfYear() {
        return nameOfYear;
    }
}
