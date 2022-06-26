package com.sergdalm.week8.homework.util;

public final class DelimiterUtil {
    private final static String COMMA_SPACE = ", ";
    private final static String SPACE = " ";
    private final static String OPEN_PARENTHESES = "(";
    private final static String CLOSING_PARENTHESES = ")";
    private final static String DASH = "-";


    private DelimiterUtil() {
    }

    public static String getCommaSpace() {
        return COMMA_SPACE;
    }

    public static String getSpace() {
        return SPACE;
    }

    public static String getOpenParentheses() {
        return OPEN_PARENTHESES;
    }

    public static String getClosingParentheses() {
        return CLOSING_PARENTHESES;
    }

    public static String getDash() {
        return DASH;
    }


}
