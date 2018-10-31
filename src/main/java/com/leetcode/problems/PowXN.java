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
    double X = x;
    long N = (n == Integer.MIN_VALUE) ? Long.parseLong(String.valueOf(n)) : n;
    if (N < 0) {
      N = Math.abs(N);
      X = 1 / X;
    }

    return pow(X, N);
  }

  private double pow(double x, long n) {
    if (n == 0) {
      return 1;
    }

    return (n & 1) == 0 ? pow(x * x, n / 2) : x * pow(x * x, n / 2);
  }

}
