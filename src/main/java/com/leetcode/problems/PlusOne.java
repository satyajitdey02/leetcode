package com.leetcode.problems;

/**
 * Created by satyajit on 11/28/18.
 */
public class PlusOne {

  public static void main(String[] args) {
    PlusOne instance = new PlusOne();
    System.out.println(instance.plusOne(new int[]{8, 9, 9, 8}));
  }

  public int[] plusOne(int[] digits) {

    if (digits[digits.length - 1] < 9) {
      digits[digits.length - 1]++;
      return digits;
    }

    int carry = 1;
    for (int i = digits.length - 1; i >= 0; i--) {
      int sum = digits[i] + carry;
      digits[i] = sum % 10;
      carry = sum / 10;
    }

    if (carry == 0) {
      return digits;
    }

    int[] result = new int[digits.length + 1];
    System.arraycopy(digits, 0, result, 1, digits.length);
    result[0] = carry;

    return result;
  }
}
