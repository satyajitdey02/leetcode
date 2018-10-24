package com.leetcode.problems;

/**
 * Created by satyajit on 10/24/18.
 */
public class MaximumSubarray {

  public static void main(String[] args) {
    MaximumSubarray instance = new MaximumSubarray();
    //instance.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
    //instance.maxSubArray(new int[]{1, 2});
    //instance.maxSubArray(new int[]{-2, 1});
    instance.maxSubArray(new int[]{8, -19, 5, -4, 20});
  }

  public int maxSubArray(int[] nums) {
    boolean discontinuous = false;
    int sum = nums[0];
    int sumMax = sum;
    for (int i = 1; i < nums.length; i++) {
      if (discontinuous) {
        sum = nums[i];
        discontinuous = false;
        continue;
      }

      if ((sum + nums[i] > sum) || (sum + nums[i] > nums[i])) {
        sum += nums[i];
      }

      if (nums[i] > sum) {
        sum = nums[i];
        //continue;
      }

      if (nums[i] + sum < sum && nums[i] < nums[i - 1]) {
        discontinuous = true;
      }

      sumMax = Math.max(sumMax, Math.max(sum, nums[i]));
    }

    return sumMax;
  }

}
