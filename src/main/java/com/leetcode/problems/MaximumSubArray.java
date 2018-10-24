package com.leetcode.problems;

/**
 * Created by satyajit on 10/24/18.
 */
public class MaximumSubArray {

  public static void main(String[] args) {
    MaximumSubArray instance = new MaximumSubArray();
    //System.out.println(instance.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    System.out.println(instance.maxSubArray(new int[]{1, 2}));
    //System.out.println(instance.maxSubArray(new int[]{-2, 1}));
    //System.out.println(instance.maxSubArray(new int[]{8, -19, 5, -4, 20}));
  }

  /*
  //O(n) solution
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
  }*/

  //Divide & Conquer solution
  private int divide(int[] nums, int start, int end) {
    int maxSum = nums[start];
    if (end > start) {
      int mid = start + (end - start) / 2;
      divide(nums, start, mid);
      divide(nums, mid + 1, end);
    }

    maxSum = conquer(nums, start, end, maxSum);
    return maxSum;
  }

  private int conquer(int[] nums, int start, int end, int maxSum) {
    int sumMax = maxSum;
    if (start == end) {
      return Math.max(sumMax, nums[start]);
    }

    int sum = nums[start];
    for (int i = start + 1; i <= end; i++) {
      sum += nums[i];
      if (nums[i] > sum) {
        sum = nums[i];
      }

      sumMax = Math.max(sumMax, sum);
    }

    return sumMax;
  }

  public int maxSubArray(int[] nums) {
    return divide(nums, 0, nums.length - 1);
  }

}
