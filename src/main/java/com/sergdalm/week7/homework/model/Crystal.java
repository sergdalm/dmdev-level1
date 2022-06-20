package com.sergdalm.week7.homework.model;


import com.sergdalm.week7.homework.utril.RandomUtil;

public enum Crystal {
    RED_CRYSTAL,
    WHITE_CRYSTAL;

    public static Crystal getRandomCrystal() {
        boolean random = RandomUtil.getRandomBoolean();
        if (random)
            return RED_CRYSTAL;
        else
            return WHITE_CRYSTAL;
    }
}
