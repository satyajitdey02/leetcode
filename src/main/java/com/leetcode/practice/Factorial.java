package com.leetcode.practice;

public class Factorial {

  private long factorial(int n) {
    if (n == 0 || n == 1) {
      return 1;
    }

    return n * factorial(n - 1);
  }

  public static void main(String[] args) {
    Factorial instance = new Factorial();
    System.out.println(instance.factorial(10));
  }
}
