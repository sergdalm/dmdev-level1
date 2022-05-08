package com.sergdalm.week1.task;

import com.sergdalm.week1.task.Task0;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Task0Test {
    @Test
    void checkDateVerification() {
        Assertions.assertTrue(Task0.dateVerification("12.07.1993"));
        Assertions.assertFalse(Task0.dateVerification("32.07.1993"));
        Assertions.assertFalse(Task0.dateVerification("01.13.1993"));
        Assertions.assertFalse(Task0.dateVerification("00.13.1993"));
        Assertions.assertFalse(Task0.dateVerification("120.07.1993"));
        Assertions.assertFalse(Task0.dateVerification("01.00.1993"));
        Assertions.assertFalse(Task0.dateVerification("0.07.1993"));
        Assertions.assertFalse(Task0.dateVerification("01.2.1993"));
        Assertions.assertFalse(Task0.dateVerification("01.0o.1993"));
        Assertions.assertTrue(Task0.dateVerification("29.02.2020"));
    }

    @Test
    void checkNextDate(){

        Assertions.assertEquals(Task0.getNextDay("31.01.2022"),"01.02.2022");
        Assertions.assertEquals(Task0.getNextDay("31.12.2021"), "01.01.2022");
        Assertions.assertEquals(Task0.getNextDay("28.02.2022"), "01.03.2022");
        Assertions.assertEquals(Task0.getNextDay("29.02.2020"), "01.03.2020");
    }

}
