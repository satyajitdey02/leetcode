package com.leetcode.problems;

/**
 * Created by satyajit on 11/28/18.
 */
public class PlusOne {

  public static void main(String[] args) {
    PlusOne instance = new PlusOne();
    System.out.println(instance.plusOne(new int[]{9}));
  }

  public int[] plusOne(int[] digits) {

    int n = digits.length;
    for (int i = n - 1; i >= 0; i--) {
      if (digits[i] < 9) {
        digits[i]++;
        return digits;
      }

      digits[i] = 0;
    }

    int[] newNumber = new int[n + 1];
    newNumber[0] = 1;

    return newNumber;
  }
}
