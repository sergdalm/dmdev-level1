package com.sergdalm.week5.homework;

import java.util.*;

import static java.util.stream.Collectors.*;

/**
 * Дан список студентов с полями:
 * - Имя
 * - Фамилия
 * - Номер курса в университете
 * - Список оценок за учебу
 * <p>
 * Преобразовать этот список студентов в ассоциативный массив,
 * где ключом является номер курса, а значением:
 * <p>
 * 1. Средняя оценка студентов этого курса, количество оценок у которых больше 3-х
 * <p>
 * 2. Список студентов данного курса, но только с полями Имя и Фамилия.
 * Список должен быть отсортированы по этим двум полям
 * <p>
 * 3. Объект с двумя полями:
 * - Отсортированный список студентов с пункта 2
 * - Средняя оценка этих студентов
 * <p>
 * Подумать, как ассоциативный массив можно было представить в коде
 * в виде отсортированного - TreeMap
 */
public class StudentRunner {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(List.of(
                new Student("Petr", "Petrov", YearOfUniversity.FIRST, List.of(Mark.A, Mark.B)),
                new Student("Ivan", "Ivanov", YearOfUniversity.THIRD, List.of(Mark.C, Mark.E, Mark.D, Mark.D, Mark.E, Mark.E)),
                new Student("Kirill", "Kirillov", YearOfUniversity.FOURTH, List.of(Mark.A, Mark.A, Mark.A, Mark.A, Mark.A, Mark.A)),
                new Student("Mark", "Markov", YearOfUniversity.SECOND, List.of(Mark.B, Mark.B, Mark.B)),
                new Student("Andrey", "Andreyev", YearOfUniversity.SECOND, List.of(Mark.A, Mark.A, Mark.B, Mark.B, Mark.B))
        ));

        /* 1.
          Преобразовать этот список студентов в ассоциативный массив,
          где ключом является номер курса, а значением:
          Средняя оценка студентов этого курса, количество оценок у которых больше 3-х
         */
        Map<YearOfUniversity, Double> averageMarksByYear = students.stream()
                .filter(s -> s.getMarks().size() > 3)
                .collect(
                        groupingBy(Student::getYear,
                                averagingInt(Student::getAverageMarkInt)));

        System.out.println(averageMarksByYear);

        /* 2.
          Преобразовать этот список студентов в ассоциативный массив,
          где ключом является номер курса, а значением:
          Список студентов данного курса, но только с полями Имя и Фамилия.
          Список должен быть отсортирован по этим двум полям
         */
        Map<YearOfUniversity, List<StudentWithNameOnly>> studentsWithName2 =
                students.stream()
                        .collect(groupingBy(Student::getYear,
                                mapping(s -> new StudentWithNameOnly(s.getFirstName(),
                                                s.getLastName()),
                                        toList())));

        for (Map.Entry<YearOfUniversity, List<StudentWithNameOnly>> entry : studentsWithName2.entrySet()) {
            Collections.sort(entry.getValue());
        }

        System.out.println(studentsWithName2);


        /* 3.
          Преобразовать этот список студентов в ассоциативный массив,
          где ключом является номер курса, а значением:
          Объект с двумя полями:
          - Отсортированный список студентов с пункта 2
          - Средняя оценка этих студентов
         */

//        LinkedHashMap<YearOfUniversity, StudentsWithAverageMark>
//                map = students.stream()
//                .collect(
//                        Collectors
//                                .toMap(
//                                        Student::getYear,
//
//                                        s -> {
//                                            return new StudentsWithAverageMark(
//                                                    List.of(
//                                                    new StudentWithNameOnly(s.getFirstName(), s.getLastName())), s.getAverageMark());
//                                        }
//                                ));


    }
}
