package com.sergdalm.week5.practice;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

/**
 * 5. Дан класс Person с полями firstName, lastName,
 * age.
 * Вывести полное имя самого старшего человека, у
 * которого длина этого имени не превышает 15
 * символов.
 */
public class Task5 {
    public static void main(String[] args) {
        var people = List.of(
                new Person("Ivan", "Ivanov", 20),
                new Person("Petr", "Petrov", 20),
                new Person("Mark", "Markov", 45),
                new Person("Oleg", "Olegov", 26),
                new Person("Alexandr", "Olegovich", 30)
        );

        people.stream()
                .filter(p -> (p.getFullName()).length() < 15)
                .max(Comparator.comparing(Person::getAge))
                .map(Person::getFullName)
                .ifPresent(System.out::println);

        Map<Integer, Person> map = people.stream()
                .collect(toMap(Person::getAge,
                        Function.identity(),
                        (existingValue, newValue) -> existingValue,
                        TreeMap::new));

        System.out.println(map);

        Map<Integer, List<String>> map2 = people.stream()
                .collect(groupingBy(Person::getAge,
                        mapping(Person::getFullName, toList())));

        System.out.println(map2);

        var map3 = people.stream()
                .collect(toMap(Person::getAge,
                        Function.identity(),
                        (existingValue, newValue) -> existingValue));
        System.out.println(map3);
    }
}

