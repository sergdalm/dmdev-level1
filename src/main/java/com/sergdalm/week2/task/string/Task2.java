package com.sergdalm.week2.task.string;

/**
 * Написать программу, преобразующую строку, содержащую число
 * в римском формате, в число в арабском формате.
 * Границы чисел: от 1 до 3999.
 * <p>
 * Предусмотреть случай, когда меньший символ идёт перед большим:
 * Например CM == 900.
 * <p>
 * Соответствие:
 * M 1000
 * D 500
 * C 100
 * L 50
 * X 10
 * V 5
 * I 1
 */
public class Task2 {
    public static void main(String[] args) {
        String romanNumber = "CM";
        int arabicNumber = convertToArabicNumber(romanNumber);
        System.out.println(arabicNumber);
    }

    private static int convertToArabicNumber(String romanNumber) {

        char[] romanArray = new char[romanNumber.length()];
        for (int i = 0; i < romanNumber.length(); i++) {
            romanArray[i] = romanNumber.charAt(i);
        }
        int result = 0;
        for (int i = 0; i < romanArray.length - 1; i++) {
            int thisNumber = romanToArabic(romanArray[i]);
            int nextNumber = romanToArabic(romanArray[i + 1]);
            if (thisNumber < nextNumber) {
                result += nextNumber - thisNumber;
                i++;
            } else {
                result += thisNumber;
            }
        }
        return result;
    }

    private static int romanToArabic(char c) {
        return switch (c) {
            case ('M') -> 1000;
            case ('D') -> 500;
            case ('C') -> 100;
            case ('L') -> 50;
            case ('X') -> 10;
            case ('V') -> 5;
            case ('I') -> 1;
            default -> 0;
        };
    }
}
