package com.sergdalm.week4.homework.task1;

import java.util.*;

/**
 * Дан список чатов.
 * Каждый чат состоит из двух полей: название и количество пользователей в этом чате.
 * <p>
 * Задача:
 * - Удалить с помощью итератора из этого списка те чаты, что содержат менее 1000 пользователей.
 * - Оставшиеся чаты отсортировать с помощью компараторов по убыванию по количеству пользователей,
 * а если это количество совпадает, то по названию в алфавитном порядке.
 * - Также предоставить сортировку чатов по названию по умолчанию.
 */
public class ChatRunner {

    public static void main(String[] args) {
        List<Chat> chats = new ArrayList<>();
        chats.add(new Chat("Cute cats", 2500));
        chats.add(new Chat("Java", 5000));
        chats.add(new Chat("Netflix Heartstopper", 2600));
        chats.add(new Chat("Crazy ex-girlfriend TV show", 2600));
        chats.add(new Chat("Sport", 14500));
        chats.add(new Chat("Dachshunds are cutest dogs", 600));

        System.out.println(chats);

        // Удалить с помощью итератора из этого списка те чаты, что содержат менее 1000 пользователей.
        //chats.removeIf(chat -> chat.getNumberOfUsers() < 1000);
        Iterator<Chat> iterator = chats.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getNumberOfUsers() < 1000) {
                iterator.remove();
            }
        }
        System.out.println("After removing");
        System.out.println(chats);
        Collections.sort(chats);

//         Оставшиеся чаты отсортировать с помощью компараторов по убыванию по количеству пользователей,
//         а если это количество совпадает, то по названию в алфавитном порядке.
        chats.sort(ComparatorByNumberOfUserAndNames());
        System.out.println("After sorting");
        System.out.println(chats);
    }

    private static Comparator<Chat> ComparatorByNumberOfUserAndNames() {
        return (chat1, chat2) -> {
            if (chat1.getNumberOfUsers() != chat2.getNumberOfUsers()) {
                return chat2.getNumberOfUsers() - chat1.getNumberOfUsers();
            } else {
                return chat1.compareTo(chat2);
            }
        };
    }

}
