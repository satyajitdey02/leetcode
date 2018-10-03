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

    int c = 0, sign = 0;

    if (dividend < 0) {
      dividend = negate(dividend);
      sign ^= 1;
    }

    if (divisor < 0) {
      divisor = negate(divisor);
      sign ^= 1;
    }

    if (divisor != 0) {
      while (dividend >= divisor) {
        dividend = sub(dividend, divisor);
        ++c;
      }
    }
    if (sign != 0) {
      c = negate(c);
    }
    return c;
  }

  public int add(int x, int y) {

    while (y != 0) {

      int carry = x & y;

      x = x ^ y;

      y = carry << 1;
    }
    return x;
  }

  public int negate(int x) {
    return add(~x, 1);
  }

  public int sub(int x, int y) {
    return add(x, negate(y));
  }

  public static void main(String[] args) {
     System.out.println(new DivideTwoIntegers().divide(Integer.MAX_VALUE, 3));
   // System.out.println(4 << 1);
  }

}
