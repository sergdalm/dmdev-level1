package com.sergdalm.week5.homework2;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

/**
 * Дан список студентов с полями:
 * - Имя
 * - Фамилия
 * - Номер курса в университете
 * - Список оценок за учебу
 * <p>
 * Преобразовать этот список студентов в ассоциативный массив, где ключом является номер курса, а значением:
 * <p>
 * Средняя оценка студентов этого курса, количество оценок у которых больше 3-х
 * <p>
 * Список студентов данного курса, но только с полями Имя и Фамилия.
 * Список должен быть отсортированы по этим двум полям
 * <p>
 * Объект с двумя полями:
 * - Отсортированный список студентов с пункта 2
 * - Средняя оценка этих студентов
 */
public class Task {
    public static void main(String[] args) {
        var students = List.of(
                new Student("Ivan", "Ivanov", 1, List.of(5, 4, 5)),
                new Student("Petr", "Petrov", 3, List.of(5, 4, 5, 5, 5, 4, 4, 5, 5)),
                new Student("Mark", "Markov", 2, List.of(4, 4, 4, 4, 4, 4)),
                new Student("Egor", "Egorov", 2, List.of(3, 3, 3, 3, 3, 3)),
                new Student("Oleg", "Petrov", 4, List.of(4, 4, 3, 3, 3, 3, 3, 4, 3, 4, 5, 3))
        );

        //Преобразовать этот список студентов в ассоциативный массив,
        // где ключом является номер курса, а значением:
        // Средняя оценка студентов этого курса,
        // количество оценок у которых больше 3-х
        Map<Integer, Double> averageMarksByYear = students.stream()
                .filter(s -> s.getMarks().size() > 3)
                .collect(groupingBy(Student::getUniversityYear,
                        averagingDouble(Student::getAverageMark)));

        System.out.println(averageMarksByYear);

        // Преобразовать этот список студентов в ассоциативный массив,
        // где ключом является номер курса, а значением:
        // Список студентов данного курса, но только с полями Имя и Фамилия.
        // Список должен быть отсортированы по этим двум полям
        Map<Integer, List<StudentDto>> studentDtoMap = students.stream()
                .collect(groupingBy(Student::getUniversityYear,
                        mapping(s -> new StudentDto(s.getFirstName(), s.getLastName()), toList())));
        System.out.println(studentDtoMap);


        // Преобразовать этот список студентов в ассоциативный массив,
        // где ключом является номер курса, а значением:
        // Объект с двумя полями:
        // - Отсортированный список студентов с пункта 2
        // - Средняя оценка этих студентов
        Map<Integer, AverageMarkOfStudents> averageMarkOfStudentsMap = students.stream()
                .collect(groupingBy(Student::getUniversityYear,
                        collectingAndThen(mapping(s -> new StudentDto(s.getFirstName(), s.getLastName()), toList()),
                                dtoList -> new AverageMarkOfStudents(dtoList, students.
                                        stream()
                                        .filter(s -> dtoList.contains(new StudentDto(s.getFirstName(), s.getLastName())))
                                        .mapToDouble(Student::getAverageMark)
                                        .average()
                                        .orElse(0)))));

        System.out.println(averageMarkOfStudentsMap);
    }
}
