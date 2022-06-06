package com.sergdalm.week5.homework;

public class StudentWithNameOnly implements Comparable<StudentWithNameOnly> {
    private String firstName;
    private String lastName;

    public StudentWithNameOnly(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "StudentWithNameOnly{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public int compareTo(StudentWithNameOnly o) {
        return firstName.compareTo(o.getFirstName()) == 0 ?
                lastName.compareTo(o.getLastName()) :
                firstName.compareTo(o.getFirstName());
    }
}
