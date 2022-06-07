package com.sergdalm.week5.homework2;


import java.util.List;

public class AverageMarkOfStudents {
    private final List<StudentDto> students;
    private final double averageMark;

    public AverageMarkOfStudents(List<StudentDto> students, double averageMark) {
        this.students = students;
        this.averageMark = averageMark;
    }

    public List<StudentDto> getStudents() {
        return students;
    }

    public double getAverageMark() {
        return averageMark;
    }

    @Override
    public String toString() {
        return "AverageMarkOfStudents{" +
                "students=" + students +
                ", averageMark=" + averageMark +
                '}';
    }
}
