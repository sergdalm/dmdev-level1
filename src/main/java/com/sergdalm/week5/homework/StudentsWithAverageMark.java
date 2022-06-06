package com.sergdalm.week5.homework;

import java.util.ArrayList;
import java.util.List;

public class StudentsWithAverageMark {
    private List<StudentWithNameOnly> students;
    private Mark averageMark;

    public StudentsWithAverageMark(List<StudentWithNameOnly> students, Mark averageMark) {
        this.students = new ArrayList<>(students);
        this.averageMark = averageMark;
    }


    public List<StudentWithNameOnly> getStudents() {
        return students;
    }

    public Mark getAverageMark() {
        return averageMark;
    }
}
