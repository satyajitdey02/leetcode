package com.leetcode.practice;

public class Fibonacci {

  long fibonacci(int n) {
    if (n <= 1 || n == 2) {
      return 1;
    }

    return fibonacci(n - 1) + fibonacci(n - 2);
  }

  public static void main(String[] args) {
    Fibonacci instance = new Fibonacci();
    System.out.println(instance.fibonacci(7));
  }
}
