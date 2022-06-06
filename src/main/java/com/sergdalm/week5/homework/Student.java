package com.sergdalm.week5.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Дан список студентов с полями:
 * - Имя
 * - Фамилия
 * - Номер курса в университете
 * - Список оценок за учебу
 */
public class Student {
    private String firstName;
    private String lastName;
    private YearOfUniversity year;
    private List<Mark> marks;
    private Map<Integer, String> marksMap;

    public Student(String firstName, String lastName, YearOfUniversity year, List<Mark> marks) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.year = year;
        this.marks = new ArrayList<>(marks);
        this.marksMap = new TreeMap<>();
        initializeMarksMap();
    }

    private void initializeMarksMap() {
        for (Mark mark : Mark.values()) {
            marksMap.put(mark.getMarkNumber(), mark.name());
        }
    }

    public Student(String firstName, String lastName, YearOfUniversity year) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.year = year;
        this.marks = new ArrayList<>();
    }

    public void receiveMark(Mark mark) {
        marks.add(mark);
    }

    public Mark getAverageMark() {
        int sum = 0;
        for (Mark mark : marks) {
            sum += mark.getMarkNumber();
        }
        int average = sum / marks.size();
        return castIntoToMark(average);
    }

    public int getAverageMarkInt() {
        return getAverageMark().getMarkNumber();
    }

    private Mark castIntoToMark(int number) {
        return Mark.valueOf(marksMap.get(number));
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public YearOfUniversity getYear() {
        return year;
    }

    public List<Mark> getMarks() {
        return marks;
    }
}
