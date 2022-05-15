package com.sergdalm.week2.homework.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Task2Test {
    @Test
    public void checkOutputArray() {
        Assertions.assertArrayEquals(
                Task2.convertIntoIntArray(new char[]{'a', '6', 'y', 'P', 'T', 'q', '9', '+'}),
                new int[]{97, 54, 121, 80, 84, 113, 57, 43});
    }

    @Test
    public void checkAverageOfArray() {
        Assertions.assertEquals(
                Task2.getAverageValue(new int[]{1, 2, 3}),
                2);
    }
}
