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

  public int maxArea_On(int[] height) {
    int result = 0, left = 0, right = height.length - 1;
    while (left != right) {
      result = Math.max(result, Math.min(height[left], height[right]) * (right - left));
      if (height[left] > height[right]) {
        right--;
      } else {
        left++;
      }
    }

    return result;
  }

  public static void main(String[] args) {
    int[] input = {1, 8, 6, 2, 5, 4, 8, 3, 7};

    long start = System.nanoTime();
    int result = new ContainerWithMostWater().maxArea(input);
    long end = System.nanoTime();
    System.out.println("maxArea = " + result + ", ET = " + (end-start));

    start = System.nanoTime();
    result = new ContainerWithMostWater().maxArea_On(input);
    end = System.nanoTime();
    System.out.println("maxArea_On = " + result + ", ET = " + (end-start));
  }

}
