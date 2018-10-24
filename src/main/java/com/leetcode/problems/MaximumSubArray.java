package com.leetcode.problems;

/**
 * Created by satyajit on 10/24/18.
 */
public class MaximumSubArray {

  public static void main(String[] args) {
    MaximumSubArray instance = new MaximumSubArray();
    instance.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
    instance.maxSubArray(new int[]{1, 2});
    instance.maxSubArray(new int[]{-2, 1});
    instance.maxSubArray(new int[]{8, -19, 5, -4, 20});
  }

  public int maxSubArray(int[] nums) {
    int sum = nums[0];
    int sumMax = sum;

    for (int i = 1; i < nums.length; i++) {
      sum += nums[i];
      if (nums[i] > sum) {
        sum = nums[i];
      }

      sumMax = Math.max(sumMax, sum);
    }

    return sumMax;
  }

}
