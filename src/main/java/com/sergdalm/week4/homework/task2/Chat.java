package com.sergdalm.week4.homework.task2;

import java.util.ArrayList;
import java.util.List;

public class Chat implements Comparable<Chat> {
    private final String name;
    private final List<User> users;

    public Chat(String name, List<User> users) {
        this.name = name;
        this.users = new ArrayList<>(users);
    }

    public Chat(String name) {
        this.name = name;
        this.users = new ArrayList<>();
    }

    @Override
    public int compareTo(Chat chat) {
        return this.name.compareTo(chat.getName());
    }

    public String getName() {
        return name;
    }

    public int getNumberOfUsers() {
        return users.size();
    }

    public List<User> getUsers() {
        return new ArrayList<>(users);
    }

    public void addUsers(User user) {
        this.users.add(user);
    }

    public void RemoveUsers(User user) {
        users.remove(user);
    }

    @Override
    public String toString() {
        return "Chat name: " + name + ", number of users: " + users.size();
    }
}
