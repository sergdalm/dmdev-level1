package com.sergdalm.week1.homework.loops;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Task2Test {

    @Test
    public void checkReserveNumber() {
        assertEquals(Task2.getReversedNumber(12345), 54321);
        assertEquals(Task2.getReversedNumber(900), 9);
        assertEquals(Task2.getReversedNumber(6789), 9876);
    }
}
