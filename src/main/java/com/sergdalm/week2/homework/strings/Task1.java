package com.sergdalm.week2.homework.strings;

/**
 * Дана строка.
 * Удалить из нее все повторяющиеся символы без учета регистра,
 * если они идут друг за другом. Также удалить пробелы.
 * Результат привести к верхнему регистру.
 * <p>
 * Например:
 * "abc Cpddd Dio OsfWw" -> "ABCPDIOSFW"
 */
public class Task1 {

    public static void main(String[] args) {
        String str = "abc Cpddd Dio OsfWw";

        String str2 = removeAllDuplicatesAndSpacesToUpperCase(str);
        System.out.println(str2);
    }

    public static String removeAllDuplicatesAndSpacesToUpperCase(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        String strWithoutSpaces = str.replaceAll(" ", "").toUpperCase();
        int count = 0;
        for (int i = 0; i < strWithoutSpaces.length() - 1; i++) {
            char c = strWithoutSpaces.charAt(i);
            if (!contains(stringBuilder, c)) {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }

    private static boolean contains(StringBuilder stringBuilder, char c) {
        for (int i = 0; i < stringBuilder.length(); i++) {
            if (stringBuilder.charAt(i) == c)
                return true;
        }
        return false;
    }
}
