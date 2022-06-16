package com.sergdalm.week7.task.producer;

import java.util.Random;

public final class RandomUtils {
    private final static int DEFAULT_BOUND = 10;
    private final static Random RANDOM = new Random();

    private RandomUtils() {

    }

    public static int getRandom() {
        return RANDOM.nextInt(DEFAULT_BOUND);
    }

    public static int getRandom(int bound) {
        return RANDOM.nextInt(bound);
    }
}
