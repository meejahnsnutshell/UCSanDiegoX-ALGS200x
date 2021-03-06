package main.java.FibbonacciNumber;

import java.math.BigInteger;
import java.util.Scanner;

public class LastDigOfLargeFib {

    private static BigInteger calc_fib(int n) {
        final double sqrtFive = Math.sqrt(5);
        // Golden ratio numbers, used mathematically to evaluate n-th fibonacci
        final double bigPhi = 1.6180339;
        final double littlePhi = -1 / bigPhi;
        BigInteger theFib = BigInteger.valueOf(0);
        if (n <= 1) {
            return BigInteger.valueOf(n);
        } else if (n > 1 && n <= 28) {
            // golden ratio works up to 28
            // must round up (to an int) to work
            theFib = BigInteger.valueOf(Math.round((Math.pow(bigPhi, n) - Math.pow(littlePhi, n)) / sqrtFive));
            return theFib.mod(BigInteger.valueOf(10));
        } else { //if (n > 28)
            // Calculate the 27 & 28th Fib num, then continue on calculating by addition
            // use only the last digit from the beginning
            BigInteger prev2 = BigInteger.valueOf(Math.round((Math.pow(bigPhi, 27) - Math.pow(littlePhi, 27)) / sqrtFive));
            prev2 = prev2.mod(BigInteger.valueOf(10));
            BigInteger prev = BigInteger.valueOf(Math.round((Math.pow(bigPhi, 28) - Math.pow(littlePhi, 28)) / sqrtFive));
            prev = prev.mod(BigInteger.valueOf(10));
            for (int i = 28; i < n; i++) {
                theFib = prev2.add(prev).mod(BigInteger.valueOf(10));
                prev2 = prev;
                prev = theFib;
            }
            return theFib;
        }
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.println(calc_fib(n));
    }

}
