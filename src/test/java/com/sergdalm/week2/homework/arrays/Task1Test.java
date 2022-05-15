package com.sergdalm.week2.homework.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Task1Test {
    @Test
    public void checkOutputArray() {
        assertArrayEquals(
                Task1.removeNegativeNumbers(new int[]{3, 5, -6, 3, 2, -9, 0, -123}),
                new int[]{15, 25, 15, 10, 0});
    }
}
