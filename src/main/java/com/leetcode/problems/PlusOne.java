package com.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by satyajit on 11/28/18.
 */
public class PlusOne {

  public static void main(String[] args) {
    PlusOne instance = new PlusOne();
    System.out.println(instance.plusOne(new int[]{9}));
  }

  public int[] plusOne(int[] digits) {
    List<Integer> temp = new ArrayList<>();
    int carry = 1;
    for (int i = digits.length - 1; i >= 0; i--) {
      int sum = (digits[i] + carry) % 10;
      temp.add(sum);
      carry = (digits[i] + carry) / 10;
    }

    if (carry > 0) {
      temp.add(carry);
    }

    int[] result = new int[temp.size()];
    int index = 0;
    for (int j = temp.size() - 1; j >= 0; j--) {
      result[index++] = temp.get(j);
    }

    return result;
  }
}
