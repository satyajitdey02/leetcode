package com.leetcode.problems;

public class SearchInRotatedSortedArray {

  public int search(int[] nums, int target) {
    if (nums.length == 0) {
      return -1;
    }

    int start = 0, end = nums.length - 1;
    while (start <= end) {
      int mid = (start + end) / 2;
      if (nums[mid] == target) {
        return mid;
      }
      if ((nums[0] > target) ^ (nums[0] > nums[mid]) ^ (target > nums[mid])) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    
    return -1;
  }

  public static void main(String[] args) {
    int nums[] = {4, 5, 6, 7, 0, 1, 2};
    System.out.println(new SearchInRotatedSortedArray().search(nums, 0));
  }

}
