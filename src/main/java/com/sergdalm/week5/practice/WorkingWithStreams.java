package com.sergdalm.week5.practice;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WorkingWithStreams {
    public static void main(String[] args) {
        List<String> names = List.of("Alex", "Zara", "Nick");
        Stream<String> stream = names.stream();
        Stream<String> namesStream = Stream.of("Alex", "Zara", "Nick");
        Stream<Object> streamFromArray = Arrays.stream(names.toArray());

        List<Person> people = List.of(
                new Person("Ivan", 21),
                new Person("Petya", 18),
                new Person("Oscar", 15),
                new Person("Sveta", 27),
                new Person("Kirill", 25),
                new Person("Nadya", 30),
                new Person("Olesya", 13),
                new Person("Kira", 40)

        );

        // вопрос по поводу порядка операций в стримах
        // Если мы фильтруем, затем лимитируем
        List<Person> youngPeople = people.stream()
                .filter(person -> person.getAge() <= 18)
//                .peek(System.out::println)
                .limit(2)
                .toList();

        // Create infinite random double values
        Stream<Double> randomNumber = Stream.generate(Math::random);

        // Create infinite stream of 0, 1, 2, 3..
        Stream<BigInteger> integers = Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE));

        String contents = "Hi how are you?";
        // Create a stream with words of the sentence
        Stream<String> words = Pattern.compile("[\\P{L}]+").splitAsStream(contents);
        //words.forEach(System.out::println);

//        // Transform all words to lowercase
//        Stream<String> lowercaseWords = words.map(String::toLowerCase);
//
//        // Get a first character of all words in the stream
//        Stream<Character> firstChars = lowercaseWords.map(w -> w.charAt(0));
//        //firstChars.forEach(System.out::println);

        //Stream<Stream<Character>> result = words.map(WorkingWithStreams::characterStream);
        //Stream<Character> characterStream = words.flatMap(WorkingWithStreams::characterStream);

//        result.forEach(s -> {
//            s.forEach(System.out::println);
//            System.out.println();
//        });

        // Yields the stream ['H', 'e', 'l', 'l', 'o', 'W', 'o', 'r', 'l', 'd']
        Stream<Character> combined = Stream.concat(characterStream("Hello"), characterStream("World"));
        //combined.forEach(System.out::println);

        Stream<Integer> integerStream = Stream.of(1, 2, 2, 2, 4, 3)
                .distinct();

        Stream.of("d", "D", "aa", "A")
                .sorted(String::compareToIgnoreCase)
                .forEach(System.out::println);

        int sum = words.mapToInt(String::length).sum();

        Map<String, Optional<Person>> collect = people.stream().collect(Collectors.groupingBy(
                Person::getName,
                Collectors.maxBy(Comparator.comparing(Person::getAge))));

        System.out.println(collect);

    }

    public static Stream<Character> characterStream(String s) {
        List<Character> result = new ArrayList<>();
        for (char c : s.toCharArray()) result.add(c);
        return result.stream();
    }

    public static <Double> Optional<Double> inverse(double d) {
        if (d == 0.0) {
            return Optional.empty();
        }

        return (Optional<Double>) Optional.of(-d);
    }

    public static <Double> Optional<Double> squareRoot(double d) {
        if (d == 0) {
            return Optional.empty();
        }
        return (Optional<Double>) Optional.of(Math.sqrt(d));
    }


}
