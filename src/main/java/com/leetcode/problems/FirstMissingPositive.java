package com.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstMissingPositive {

  public int firstMissingPositive(int[] nums) {
    int[] map = new int[nums.length + 1];
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > 0 && nums[i] <= nums.length) {
        map[nums[i]] = 1;
      }
    }
    for (int i = 1; i < map.length; i++) {
      if (map[i] == 0) {
        return i;
      }
    }
    return Math.max(nums.length + 1, 1);
  }

  public static void main(String[] args) {
    FirstMissingPositive instance = new FirstMissingPositive();
    int[] inputs = {3, 11, -9, 21, 24, 9, 25, 24, 45, 12, 10, -3, 38, -2, 21, 31, 51, 31, 9, 5, 15,
        -5, 2, -4, 52, -8, 0, 6, 15, 40, 15, 29, -3, 16, -4, 32, 35, 32, 2, 27, -10, 22, 34, 39, 31,
        2, 16, 28, 43, 35, 43, 4, 40, -9};
    System.out.println(instance.firstMissingPositive(inputs));
  }

}
