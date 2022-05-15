package com.sergdalm.week2.homework.string;

import com.sergdalm.week2.homework.strings.Task2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Task2Test {
    @Test
    public void checkOutputString() {
        Assertions.assertArrayEquals(
                Task2.getIntArray("Привет 8, как 1 2 твои дела? Может4, сделать 3 дело?"),
                new int[]{8, 1, 2, 4, 3}
        );
    }

    @Test
    public void checkSum() {
        Assertions.assertEquals(
                Task2.getSum(new int[]{8, 1, 2, 4, 3}),
                18
        );
    }
}
