package com.sergdalm.week4.homework.task2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Дан список чатов с предыдущего задания, только вместо поля
 * “количество пользователей” будет список объектов типа Пользователь,
 * который имеет 3 поля: id (целочисленный идентификатор), имя и возраст.
 * <p>
 * Задача:
 * - Преобразовать список чатов в один список пользователей всех чатов, возраст которых больше 18 лет
 * - С помощью итератора посчитать средний возраст всех оставшихся пользователей.
 */
public class ChatRunner {

    public static void main(String[] args) {
        List<Chat> chats = new ArrayList<>();
        User petya = new User("Petya", 16);
        User dima = new User("Dima", 20);
        User kirill = new User("Kirill", 28);
        User andrey = new User("Andrey", 30);
        User slava = new User("Slava", 25);
        User nikita = new User("Nikita", 27);
        User zhenya = new User("Zhenya", 15);

        chats.add(new Chat("Java", List.of(kirill, andrey, slava, zhenya)));
        chats.add(new Chat("Crazy ex-girlfriend TV show", List.of(kirill, petya, nikita)));
        chats.add(new Chat("Dachshunds are cutest dogs", List.of(petya, dima)));

        // Преобразовать список чатов в один список пользователей всех чатов,
        // возраст которых больше 18 лет
        // В данном случае фраза "больше 18 лет" трактуется как "18 лет и старше"
        // так как обычно так говорят когда имеют ввиду "совершеннолетний"
        List<User> usersOlderThanEighteen = new ArrayList<>();
        List<User> usersYoungerThanEighteen = new ArrayList<>();
        for (Chat chat : chats) {
            for (User user : chat.getUsers()) {
                if (user.getAge() >= 18 && !usersOlderThanEighteen.contains(user)) {
                    usersOlderThanEighteen.add(user);
                } else if (user.getAge() < 18 && !usersYoungerThanEighteen.contains(user)) {
                    usersYoungerThanEighteen.add(user);
                }
            }
        }

        System.out.println(usersOlderThanEighteen);

        // С помощью итератора посчитать средний возраст всех оставшихся пользователей.
        int averageAge = getAverageAge(usersYoungerThanEighteen);
        System.out.println(averageAge);
    }

    private static int getAverageAge(List<User> list) {
        Iterator<User> iterator = list.iterator();
        int sum = 0;
        while (iterator.hasNext()) {
            sum += iterator.next().getAge();
        }
        return sum / list.size();
    }
}
