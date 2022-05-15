package com.sergdalm.week2.homework.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Task3Test {
    @Test
    public void checkOutputArray() {
        Assertions.assertArrayEquals(
                Task3.separateArray(new int[]{1, 0, -3}),
                new int[][]{
                        {-3},
                        {0},
                        {1}
                });
    }
}
