package com.sergdalm.week5.homework2;

import java.util.ArrayList;
import java.util.List;

// - Имя
// - Фамилия
// - Номер курса в университете
// - Список оценок за учебу
public class Student {
    private final String firstName;
    private final String lastName;
    private final int universityYear;
    private final List<Integer> marks;

    public Student(String firstName, String lastName, int universityYear, List<Integer> marks) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.universityYear = universityYear;
        this.marks = new ArrayList<>(marks);
    }

    public double getAverageMark() {
        var optionalDouble = marks.stream()
                .mapToInt(Integer::valueOf)
                .average();
        return optionalDouble.isPresent() ?
                (int) optionalDouble.getAsDouble() :
                0;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getUniversityYear() {
        return universityYear;
    }

    public List<Integer> getMarks() {
        return marks;
    }
}
