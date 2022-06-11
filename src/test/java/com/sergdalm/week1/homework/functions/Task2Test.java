package com.sergdalm.week1.homework.functions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Task2Test {

    @Test
    public void checkCalculation() {
        assertEquals(Task2.calculate(5, 5, '+'), 10);
        assertEquals(Task2.calculate(5, 5, '/'), 1);
        assertEquals(Task2.calculate(5, 5, '*'), 25);
        assertEquals(Task2.calculate(5, 5, '-'), 0);
        assertEquals(Task2.calculate(5, 5, '%'), 0);
    }
}
