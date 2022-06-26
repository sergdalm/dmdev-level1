package com.sergdalm.week8.homework.util;

import java.util.Random;

public final class RandomUtil {
    private final static Random RANDOM = new Random();

    private RandomUtil() {
    }

    public static int getRandom(int exclusiveUpperBound) {
        return RANDOM.nextInt(exclusiveUpperBound);
    }
}
