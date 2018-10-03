package com.leetcode.practice;

/**
 * Created by satyajit on 10/3/18.
 */
public class BitWiseArithmetic {

  public int add(int x, int y) {
    int a, b;
    do {
      a = x & y;
      b = x ^ y;
      x = a << 1;
      y = b;
    } while (a != 0);

    return b;
  }

  public int negate(int x) {
    return add(~x, 1);
  }

  public int sub(int x, int y) {
    return add(x, negate(y));
  }

  public int mul(int x, int y) {
    int m = 1, z = 0;
    if (x < 0) {
      x = negate(x);
      y = negate(y);
    }

    while (x >= m && y != 0) {
      if ((x & m) != 0) {
        z = add(y, z);
      }
      y <<= 1;
      m <<= 1;
    }
    return z;
  }

  int divide(int x, int y) {
    int c = 0, sign = 0;

    if (x < 0) {
      x = negate(x);
      sign ^= 1;
    }

    if (y < 0) {
      y = negate(y);
      sign ^= 1;
    }

    if (y != 0) {
      while (x >= y) {
        x = sub(x, y);
        ++c;
      }
    }
    if (sign != 0) {
      c = negate(c);
    }
    return c;
  }


  public static void main(String[] args) {
    BitWiseArithmetic instance = new BitWiseArithmetic();
    System.out.println(instance.mul(6, 7));
  }
}
