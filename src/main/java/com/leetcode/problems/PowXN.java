package com.leetcode.problems;

/**
 * Created by satyajit on 10/25/18.
 */
public class PowXN {

  public static void main(String[] args) {
    PowXN instance = new PowXN();
    System.out.println(instance.myPow(0, 1));
  }

  public double myPow(double x, int n) {
    if (x == 0) {
      return 0;
    }

    if (n == 0) {
      return 1;
    }

    double result = 1;
    double X = x;
    int N = n < 0 ? -n : n;
    while (N != 0) {
      if ((N & 1) == 1) {
        result = result * X;
      }

      N >>>= 1;
      X *= X;
    }

    return n >= 0 ? result : 1 / result;
  }

}
