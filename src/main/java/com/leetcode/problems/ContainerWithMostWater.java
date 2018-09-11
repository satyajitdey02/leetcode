package com.leetcode.problems;

public class ContainerWithMostWater {

  public int maxArea(int[] height) {
    int result = 0;
    for (int i = 0; i < height.length; i++) {
      for (int j = i + 1; j < height.length; j++) {
        result = Math.max(result, Math.min(height[i], height[j]) * (j - i));
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[] input = {1, 8, 6, 2, 5, 4, 8, 3, 7};
    int result = new ContainerWithMostWater().maxArea(input);
    System.out.println("result = " + result);
  }

}
