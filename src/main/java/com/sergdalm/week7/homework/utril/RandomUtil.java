package com.sergdalm.week7.homework.utril;

import java.util.Random;

public final class RandomUtil {
    private static final Random RANDOM = new Random();

    private RandomUtil() {
    }

    public static boolean getRandomBoolean() {
        return RANDOM.nextBoolean();
    }

    public static int getRandomFromTwoToFive() {
        return RANDOM.nextInt(2, 6);
    }
}
