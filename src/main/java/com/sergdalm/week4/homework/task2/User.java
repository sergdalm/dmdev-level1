package com.sergdalm.week4.homework.task2;

public class User {
    private static int count;
    private final int id;
    private final String name;
    private final int age;

    public User(String name, int age) {
        this.id = count++;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User id: " + id + ", name: " + name + ", age: " + age;
    }
}
