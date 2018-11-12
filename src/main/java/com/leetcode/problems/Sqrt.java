package com.leetcode.problems;

/**
 * Created by satyajit on 10/31/18.
 */
public class Sqrt {

  public static void main(String[] args) {
    Sqrt instance = new Sqrt();
    System.out.println(instance.mySqrt(Integer.MAX_VALUE));
    System.out.println(instance.mySqrt(2));
    System.out.println(instance.mySqrt(16));

  }

  public int mySqrt(int x) {
    if (x == 0) {
      return 0;
    }

    for (int i = 1; i <= x / i; i++) {
      if ((i <= x / i) && (i + 1) > x / (i + 1)) {
        return i;
      }
    }

    return -1;
  }

}
