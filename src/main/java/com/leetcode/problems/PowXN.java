package com.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by satyajit on 10/25/18.
 */
public class PowXN {

  public static void main(String[] args) {
    PowXN instance = new PowXN();
    System.out.println(instance.myPow(2, -2));
  }

  Map<Integer, Double> map = new HashMap<>();

  public double myPow(double x, int n) {
    if (n == 0) {
      return 1.0;
    }
    double result = divide(x, n < 0 ? -n : n);
    return n < 0 ? 1 / result : result;
  }

  private double divide(double x, int n) {
    if (n > 1) {
      int m = n / 2;
      divide(x, m);
      divide(x, n - m);

      return conqueer(x, m, n - m);
    }

    map.put(1, x);
    return x;
  }

  private double conqueer(double x, int m, int n) {
    Double mValue = map.get(m);//map.computeIfAbsent(m, k -> x);
    if (n == 0) {
      return mValue;
    }

    Double nValue = map.get(n);//map.computeIfAbsent(n, k -> x);
    double value = mValue * nValue;

    map.put(m + n, value);
    return value;
  }


}
