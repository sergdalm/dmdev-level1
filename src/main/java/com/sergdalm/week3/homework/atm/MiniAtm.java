package com.sergdalm.week3.homework.atm;

public class MiniAtm extends Atm {

    public MiniAtm(int banknoteHundred, int banknoteFifty, int banknoteTwenty) {
        super(banknoteHundred, banknoteFifty, banknoteTwenty);
    }

    public static void print() {
        System.out.println("This is mini ATM");
    }
}
