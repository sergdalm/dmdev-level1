package com.sergdalm.week8.task;

import java.util.regex.Pattern;

/**
 * 1. Написать программу, проверяющую, является ли введённая
 * строка адресом почтового ящика.
 * В названии почтового ящика разрешить использование только
 * букв, цифр и нижних подчёркиваний, при этом оно должно
 * начинаться с буквы.
 * Возможные домены верхнего уровня: .org .com
 */
public class Task1 {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String input = scanner.nextLine();
        String input = "dmdev@gmail.org";
        String regex = "[a-zA-Z]\\w*@\\w+\\.(org|com)";
        System.out.println(Pattern.matches(regex, input));
    }
}
