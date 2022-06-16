package com.sergdalm.week7.practice;

import java.util.Random;

public final class RandomUtils {
    private final static Random RANDOM = new Random();
    private final static int MINIMUM = 1;
    private final static int DEFAULT_BOUND = 5;

    private RandomUtils() {
    }

    public static int getRandom() {
        return RANDOM.nextInt(MINIMUM, DEFAULT_BOUND);
    }

    public static int getRandom(int bound) {
        return RANDOM.nextInt(MINIMUM, bound);
    }

    public static int getRandom(int minimum, int bound) {
        return RANDOM.nextInt(minimum, bound);
    }
}
