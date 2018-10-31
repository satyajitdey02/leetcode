package com.leetcode.problems;

/**
 * Created by satyajit on 10/25/18.
 */
public class PowXN {

  public static void main(String[] args) {
    PowXN instance = new PowXN();
    System.out.println(instance.myPow(2, Integer.MIN_VALUE));
  }

  public double myPow(double x, int n) {
    return n < 0 ? (1 / pow(x, Math.abs(Long.parseLong(String.valueOf(n))))) : pow(x, n);
  }

  private double pow(double x, long n) {

    if (n == 0) {
      return 1;
    }

    if (n == 1) {
      return x;
    }

    if (n == 2) {
      return x * x;
    }

    if ((n & 1) != 0) {
      return x * pow(x, n - 1);
    }

    return pow(pow(x, n / 2), 2);

  }

}
