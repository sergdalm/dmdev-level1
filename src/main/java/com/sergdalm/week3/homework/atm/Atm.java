package com.sergdalm.week3.homework.atm;

public class Atm {
    private int banknoteTwenty;
    private int banknoteFifty;
    private int banknoteHundred;
    private final int TWENTY = 20;
    private final int FIFTY = 50;
    private final int HUNDRED = 100;

    public Atm(int banknoteHundred, int banknoteFifty, int banknoteTwenty) {
        this.banknoteHundred = banknoteHundred;
        this.banknoteFifty = banknoteFifty;
        this.banknoteTwenty = banknoteTwenty;
    }

    public static void print() {
        System.out.println("This is ATM");
    }

    public void addMoney(int banknoteHundred, int banknoteFifty, int banknoteTwenty) {
        this.banknoteHundred += banknoteHundred;
        this.banknoteFifty += banknoteFifty;
        this.banknoteTwenty += banknoteTwenty;
    }

    public boolean getMoney(int amount) {
        if (amount <= 0) {
            return false;
        }
        if (!checkAmount(amount)) {
            return false;
        }

        int hundreds = Math.min(banknoteHundred, Math.max(amount / HUNDRED, 0));
        int fifties = Math.min(banknoteFifty, Math.max((amount - (hundreds * HUNDRED)) / FIFTY, 0));
        int twenties = Math.min(banknoteTwenty, (amount - (hundreds * HUNDRED) - (fifties * FIFTY)) / TWENTY);

        if (amount - (hundreds * HUNDRED) -
                (fifties * FIFTY) -
                (twenties * TWENTY) > 0) {
            return false;
        }

        banknoteHundred -= hundreds;
        banknoteFifty -= fifties;
        banknoteTwenty -= twenties;
        System.out.println("Successful money withdrawal: ");
        printDetails(hundreds, fifties, twenties);
        return true;
    }

    public void printBalance() {
        System.out.println("Balance of ATM: ");
        printDetails(banknoteHundred, banknoteFifty, banknoteTwenty);
    }

    private void printDetails(int hundreds, int fifties, int twenties) {
        if (hundreds > 0) {
            System.out.println("  hundred: " + hundreds + " " + (hundreds > 1 ? "banknote" : "banknotes"));
        }
        if (fifties > 0) {
            System.out.println("  fifties: " + fifties + " " + (fifties > 1 ? "banknote" : "banknotes"));
        }
        if (twenties > 0) {
            System.out.println("  twenties: " + twenties + " " + (twenties > 1 ? "banknote" : "banknotes"));
        }
        System.out.println();
    }

    private boolean checkAmount(int amount) {
        return ((banknoteHundred * HUNDRED) + (banknoteFifty * FIFTY) + (banknoteTwenty * TWENTY)) > amount;
    }
}
