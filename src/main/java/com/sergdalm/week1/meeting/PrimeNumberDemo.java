package com.sergdalm.week1.meeting;

/**
 * Print all prime numbers
 */
public class PrimeNumberDemo {

    public static void main(String[] args) {
        printPrimeNumbers(100);
    }

    private static void printPrimeNumbers(int value) {
        boolean isPrime;

        for(int i = 2; i < value; i++) {
            isPrime = true;

            for(int j = 2; j < i; j++) {
                if(i % j == 0) {
                    isPrime = false;
                    break;
                }

            }
            if(isPrime) {
                System.out.println(i);
            }
        }
    }
}
