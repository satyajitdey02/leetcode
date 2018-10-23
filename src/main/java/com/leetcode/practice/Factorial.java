package com.leetcode.practice;

import java.util.ArrayList;
import java.util.List;

public class Factorial {

  private long factorial(int n) {
    if (n == 0 || n == 1) {
      return 1;
    }

    return n * factorial(n - 1);
  }

  private int factorialMem(int n) {
    List<Integer> dp = new ArrayList<>();
    dp.add(0, 1);
    for (int i = 1; i <= n; i++) {
      dp.add(i, dp.get(i - 1) * i);
    }

    return dp.get(dp.size() - 1);
  }

  public static void main(String[] args) {
    Factorial instance = new Factorial();

    long start = System.nanoTime();
    long fact1 = instance.factorial(5);
    long end = System.nanoTime();
    System.out.println(fact1 + "["+(end-start)+"]");

    start = System.nanoTime();
    long fact2 = instance.factorialMem(5);
    end = System.nanoTime();
    System.out.println(fact2 + "["+(end-start)+"]");
  }
}
