package com.leetcode.problems;

/**
 * Created by satyajit on 11/29/18.
 */
public class ClimbingStairs {

  public static void main(String[] args) {
    ClimbingStairs instance = new ClimbingStairs();
    System.out.println(instance.climbStairs(38));
  }

  public int climbStairs(int n) {
    if (n <= 3) {
      return n;
    }

    /*
    * Using formula of nth Fibonacci number-
    * F(n+1) = (Math.pow(phi, n+1) - Math.pow(1 - phi, n+1)) / Math.sqrt(5);
    * Here we have to find the (n+1)th Fibonacci number
    * to find the possible number of ways of climbing a n-step stairs
    */
    double phi = (Math.sqrt(5) + 1) / 2;
    double result = (Math.pow(phi, n + 1) - Math.pow(1 - phi, n + 1)) / Math.sqrt(5);

    return (int) Math.round(result);
  }
}
