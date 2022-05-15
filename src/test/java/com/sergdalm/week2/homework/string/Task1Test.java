package com.sergdalm.week2.homework.string;

import com.sergdalm.week2.homework.strings.Task1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Task1Test {
    @Test
    public void checkOutputString(){
        Assertions.assertEquals(
                Task1.removeAllDuplicatesAndSpacesToUpperCase("hel   llelle hhhhooooh hhh"),
                "HELO");

        Assertions.assertEquals(
                Task1.removeAllDuplicatesAndSpacesToUpperCase("abc Cpddd Dio OsfWw"),
                "ABCPDIOSFW");
    }
}
