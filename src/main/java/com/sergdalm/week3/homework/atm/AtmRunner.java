package com.sergdalm.week3.homework.atm;

public class AtmRunner {

    public static void main(String[] args) {
        Atm atm = new Atm(5, 100, 2);
        atm.getMoney(1170);
        atm.getMoney(1000);
        atm.getMoney(1000);

        atm.printBalance();

        Atm miniAtm = new MiniAtm(5, 5, 5);
        Atm.print();
        MiniAtm.print();
        int[] array = {1, 2};
    }
}
