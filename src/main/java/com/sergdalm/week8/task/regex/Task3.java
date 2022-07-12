package com.sergdalm.week8.task.regex;

/**
 * 3. Написать программу, выполняющую поиск в строке всех тегов
 * абзацев, в т.ч. тех, у которых есть параметры, например <p id
 * ="p1">, и замену их на простые теги абзацев <p>.
 */
public class Task3 {

    public static void main(String[] args) {
        String text = "<p id=\"p1\"> sdfjskdfkjsd </p> <b> ahakak </b> <p> djkdfdkfj </p>" +
                "sdkjsdkjdkd <p>skjsdkjs <p id=\"p2\">fsdjf4 34</p>";
        String regex = "(<p .+?>)(.+?</p>)";
        System.out.println(text.replaceAll(regex, "<p>$2"));
    }
}
