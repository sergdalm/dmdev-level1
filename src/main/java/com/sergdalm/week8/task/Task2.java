package com.sergdalm.week8.task;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 2. Написать программу, выполняющую поиск в строке
 * шестнадцатеричных чисел, записанных по правилам Java,
 * с помощью регулярных выражений и выводящую их на страницу.
 */
public class Task2 {

    public static void main(String[] args) {
        String input = "hfjffshfkjf 0x400 sfnsfjj f 0X6F90a dsjfjkdfk 0xff8f";

        String regex = "0[xX][A-Fa-f0-9]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }


        String rusText = "Привет ёжик fhfjf jf))_";
        String rusRegex = "[а-яА-яЁё]+";
        Pattern rusPattern = Pattern.compile(rusRegex);
        Matcher rusMatcher = rusPattern.matcher(rusText);
        while (rusMatcher.find()) {
            System.out.println(rusMatcher.group());
        }


        System.out.println((int) 'а');
        System.out.println((int) 'я');
        System.out.println((int) 'ё');
        System.out.println();
        System.out.println((int) 'А');
        System.out.println((int) 'Я');
        System.out.println((int) 'Ё');
    }
}
