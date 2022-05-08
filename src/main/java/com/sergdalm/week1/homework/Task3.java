package com.sergdalm.week1.homework;

/**
 * Даны два прямоугольных треугольника.
 * Каждый из них задается двумя целочисленными переменными a и b - стороны треугольника.
 * Написать код, в котором вычисляется площадь каждого треугольника
 * и затем эти площади сравниваются друг с другом.
 *
 * Для этого понадобится написать 2 функции.
 * Первая: по двум сторонам прямоугольного треугольника возвращает его площадь.
 * Вторая: сравнивает переданные площади двух треугольников
 * и выводит на консоль первый треугольник больше, меньше или равен второму.
 * Учитывать, что площадь может быть вещественным числом.
 */
public class Task3 {

    public static void main(String[] args) {
        double sideOfFirstTriangle1 = 20.0;
        double sideOfFirstTriangle2 = 25.0;

        double sideOfSecondTriangle1 = 30.0;
        double sideOfSecondTriangle2 = 50.0;

        double areaOfFirstTriangle = calculateArea(sideOfFirstTriangle1, sideOfFirstTriangle2);
        System.out.println(areaOfFirstTriangle);
        double areaOfSecondTriangle = calculateArea(sideOfSecondTriangle1, sideOfSecondTriangle2);
        System.out.println(areaOfSecondTriangle);

        compareAndShowDifferenceBetweenAreaOfTwoTriangles(areaOfFirstTriangle, areaOfSecondTriangle);

    }

    private static void compareAndShowDifferenceBetweenAreaOfTwoTriangles(double areaOfFirstTriangle,
                                                                          double areaOfSecondTriangle) {
        if(areaOfFirstTriangle > areaOfSecondTriangle) {
            System.out.println("Area of first triangle is bigger than area of second triangle");
        } else {
            System.out.println("Area of second triangle is bigger than area of first triangle");
        }
    }

    private static double calculateArea(double firstSide, double secondSide) {
        return 0.5 * (firstSide * secondSide);
    }
}
