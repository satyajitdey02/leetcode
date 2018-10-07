package com.leetcode.problems;

/**
 * Created by satyajit on 10/3/18.
 */
public class DivideTwoIntegers {

  public int divide(int dividend, int divisor) {
    if (dividend == Integer.MIN_VALUE && divisor == -1) {
      return Integer.MAX_VALUE;
    }

    if (divisor == 1) {
      return dividend;
    }

    if (dividend == divisor) {
      return 1;
    }

    if (dividend + divisor == 0) {
      return -1;
    }

    if (divisor == 2) {
      return dividend >> 1;
    }

    boolean sign = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);

    long lDivident = (long) dividend;
    if (lDivident < 0) {
      lDivident = -lDivident;

    }

    long lDivisor = (long) divisor;
    if (lDivisor < 0) {
      lDivisor = -lDivisor;

    }

    int result = 0;

    while (lDivident >= lDivisor) {
      long temp = lDivisor;
      long multiply = 1;
      while (lDivident >= (temp << 1)) {
        temp = temp << 1;
        multiply = multiply << 1;
      }

      lDivident = (int) (lDivident - temp);
      result = (int) (result + multiply);
    }

    return sign ? -result : result;
  }


  public static void main(String[] args) {
    System.out.println(new DivideTwoIntegers().divide(Integer.MAX_VALUE, 3));
    System.out.println(new DivideTwoIntegers().divide(-2147483648, -3));
  }

}
