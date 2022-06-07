package com.sergdalm.week3.task.encapsulation;

/**
 * Создать класс Point, описывающий точку в двумерных координатах.
 * Полями этого класса должны быть координаты x и y.
 * Класс должен иметь один конструктор, принимающий координаты x и y.
 * Добавьте функционал для получения скрытой информации (координаты точки),
 * а получить её можно только с помощью методов доступа (get/set).
 * Создать метод distance, принимающий объект Point и определяющий расстояние до неё.
 * Используя класс точки, создать класс Rectangle, описывающий прямоугольник.
 * В нём хранятся два поля типа Point - координаты левого верхнего и правого нижнего углов.
 * Создать следующие методы в классе Rectangle:
 * - Высчитывающий площадь прямоугольника
 * - Высчитывающий длину диагонали
 * <p>
 * Написать тестовый класс с методом main программу, демонстрирующим создание объекта
 * класса Rectangle и применение вышеперечисленных методов.
 */
public class RectangleRunner {

    public static void main(String[] args) {
        Point rightPoint = new Point(3, 4);
        Point leftPoint = new Point(1, 1);
        Rectangle rectangle = new Rectangle(rightPoint, leftPoint);
        System.out.println("Rectangle area: " + rectangle.getArea());
        System.out.println("Rectangle diagonal: " + rectangle.getDiagonalLength());
    }
}
