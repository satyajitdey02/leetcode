package com.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class FindFirstLastPositionElementSortedArray {

  public int[] searchRange(int[] nums, int target) {
    int pos0 = -1;
    int posN = -1;

    int start = 0;
    int end = nums.length - 1;

    while (start <= end) {
      if (pos0 > -1 && posN > -1) {
        break;
      }

      if (start == end) {
        if (target == nums[start] && pos0 == -1) {
          pos0 = start;
        } else if (target == nums[start] && pos0 > -1) {
          pos0 = start < pos0 ? start : pos0;
        }

        if (target == nums[end] && posN == -1) {
          posN = end;
        } else if (target == nums[end] && posN > -1) {
          posN = end > posN ? end : posN;
        }

        break;
      }

      if (target == nums[start]) {
        if (start > 0 && target == nums[start - 1]) {
          start--;
        } else {
          pos0 = start;
          start++;
        }
      }

      if (target == nums[end]) {
        if (end < nums.length - 1 && target == nums[end + 1]) {
          end++;
        } else {
          posN = end;
          end--;
        }
      }

      int mid = (start + end) / 2;
      if (target == nums[mid]) {
        if (mid > 0 && target == nums[mid - 1]) {
          start = start + 1;
        } else {
          pos0 = mid;
          start = mid + 1;
        }

        if (mid < nums.length - 1 && target == nums[mid + 1]) {
          end = end - 1;
        } else {
          posN = mid;
          end = mid - 1;
        }
      }

      if (target > nums[mid]) {
        start = mid + 1;
      } else if (target < nums[mid]) {
        end = mid - 1;
      }
    }

    if (pos0 == -1 && posN > -1) {
      return new int[]{posN, posN};
    } else if (posN == -1 && pos0 > -1) {
      return new int[]{pos0, pos0};
    }

    return new int[]{pos0, posN};
  }

  public static void main(String[] args) {
    FindFirstLastPositionElementSortedArray instance = new FindFirstLastPositionElementSortedArray();
    int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 6, 6, 6, 8, 10, 10};
    int[] results = instance.searchRange(nums, 4);
    System.out.println(String.format("[%s, %s]", results[0], results[1]));
  }

}
