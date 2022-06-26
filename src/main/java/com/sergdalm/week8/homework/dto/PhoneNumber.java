package com.sergdalm.week8.homework.dto;

import static com.sergdalm.week8.homework.util.DelimiterUtil.getClosingParentheses;
import static com.sergdalm.week8.homework.util.DelimiterUtil.getDash;
import static com.sergdalm.week8.homework.util.DelimiterUtil.getOpenParentheses;
import static com.sergdalm.week8.homework.util.DelimiterUtil.getSpace;

public record PhoneNumber(String cityCode, String firstPart, String secondPart, String thirdPart) {
    private static final String COUNTRY_CODE = "+375";

    @Override
    public String toString() {
        return COUNTRY_CODE + getSpace() + getOpenParentheses() + cityCode +
                getClosingParentheses() + getSpace() + firstPart + getDash() +
                secondPart + getDash() + thirdPart;
    }
}
