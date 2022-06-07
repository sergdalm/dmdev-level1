package com.sergdalm.week2.task.string;

import java.util.Locale;

/**
 * Проверить, является ли введённая строка палиндромом,
 * т.е. читается одинаково в обоих направлениях.
 */
public class Task1 {

    public static void main(String[] args) {
        String str = "Able was I ere I saw Elba";
        if (isPalindrome(str)) {
            System.out.println("String is palindrome");
        } else {
            System.out.println("String is not palindrome");
        }

        if (isPalindrome2(str)) {
            System.out.println("String is palindrome");
        } else {
            System.out.println("String is not palindrome");
        }
    }

    private static boolean isPalindrome(String str) {
        StringBuilder reversedWord = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            reversedWord.append(str.charAt(i));
        }
        return (str.toLowerCase().contentEquals(reversedWord.toString().toLowerCase()));
    }

    private static boolean isPalindrome2(String str) {
        StringBuilder reverse = new StringBuilder(str).reverse();
        return str.equalsIgnoreCase(reverse.toString());
    }
}
