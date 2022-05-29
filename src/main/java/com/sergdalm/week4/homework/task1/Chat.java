package com.sergdalm.week4.homework.task1;

public class Chat implements Comparable<Chat> {
    private final String name;
    private int numberOfUsers;

    public Chat(String name, int numberOfUsers) {
        this.name = name;
        this.numberOfUsers = numberOfUsers;
    }

    @Override
    public int compareTo(Chat chat) {
        return this.name.compareTo(chat.getName());
    }

    public String getName() {
        return name;
    }

    public int getNumberOfUsers() {
        return numberOfUsers;
    }

    public void addUsers(int numberOfUsers) {
        this.numberOfUsers += numberOfUsers;
    }

    public void RemoveUsers(int numberOfUsers) {
        if (numberOfUsers > this.numberOfUsers) {
            this.numberOfUsers = 0;
        } else {
            this.numberOfUsers -= numberOfUsers;
        }
    }

    @Override
    public String toString() {
        return "Chat name: " + name + ", number of users: " + numberOfUsers;
    }
}
