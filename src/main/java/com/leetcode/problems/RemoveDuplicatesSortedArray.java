package com.leetcode.problems;

/**
 * Created by satyajit on 10/2/18.
 */
public class RemoveDuplicatesSortedArray {

  public int removeDuplicates(int[] nums) {
    if (nums.length <= 1) {
      return nums.length;
    }

    int pos = 0;
    for (int i = 1; i < nums.length; i++) {
      if (nums[pos] != nums[i]) {
        pos++;
        nums[pos] = nums[i];
      }
    }

    return pos + 1;
  }

  public static void main(String[] args) {
    RemoveDuplicatesSortedArray removeDuplicatesSortedArray = new RemoveDuplicatesSortedArray();
    int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};//{0,1,2,3,4}
    int len = removeDuplicatesSortedArray.removeDuplicates(nums);
    System.out.println("Length: " + len);
    for (int i = 0; i < len; i++) {
      System.out.println(nums[i]);
    }
  }

}
