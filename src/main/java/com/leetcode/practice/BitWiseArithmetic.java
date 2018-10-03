package com.leetcode.practice;

/**
 * Created by satyajit on 10/3/18.
 */
public class BitWiseArithmetic {

  public int add(int x, int y) {
    // Iterate till there is no carry
    while (y != 0) {
      // carry now contains common
      //set bits of x and y
      int carry = x & y;

      // Sum of bits of x and y where at
      //least one of the bits is not set
      x = x ^ y;

      // Carry is shifted by one so that adding
      // it to x gives the required sum
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
    System.out.println(instance.add(6, 7));
  }
}
