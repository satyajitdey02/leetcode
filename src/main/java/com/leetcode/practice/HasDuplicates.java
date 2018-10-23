package com.leetcode.practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by satyajit on 10/15/18.
 */
public class HasDuplicates {

  public static void main(String[] args) {
    int[] inputs = {43, 6, 2, 84, 95, 98, 68, 1, 38, 68, 68, 72, 77, 72, 59, 12, 82, 24, 31, 11, 40,
        30, 21, 90, 91, 72, 36, 57, 97, 73, 41, 72, 78, 68, 12, 49, 79, 8, 80, 83, 68, 45, 73, 53,
        3, 27, 43, 78, 70, 8, 31, 48, 87, 86, 8, 74, 68, 4, 49, 77, 47, 85, 70, 97, 73, 33, 68, 12,
        41, 46, 38, 72, 67, 35, 60, 99, 45, 99, 74, 97, 37, 85, 12, 17, 33, 3, 21, 37, 22, 6, 88,
        99, 2, 31, 88, 22, 93, 44, 7, 22};

    long start = System.nanoTime();
    boolean trueOrFalse = hasDuplicateHashMapV1(inputs);
    long end = System.nanoTime();
    System.out.println(trueOrFalse);
    System.out.println("TimeNS: " + (end - start));

    start = System.nanoTime();
    trueOrFalse = hasDuplicateHashMapV2(inputs);
    end = System.nanoTime();
    System.out.println(trueOrFalse);
    System.out.println("TimeNS: " + (end - start));
  }

  private static boolean hasDuplicateSetV1(int[] inputs) {
    Set<Integer> uniqueInputs = new HashSet<>();
    for (int i = 0; i < inputs.length; i++) {
      if (!uniqueInputs.add(inputs[i])) {
        return true;
      }
    }

    return false;
  }

  private static boolean hasDuplicateHashMapV1(int[] inputs) {
    Map<Integer, Integer> uniqueInputs = new HashMap<>();
    for (int input : inputs) {
      if ((uniqueInputs.containsKey(input))) {
        return true;
      }
      uniqueInputs.put(input, input);
    }

    return !(uniqueInputs.size() == inputs.length);
  }

  private static boolean hasDuplicateHashMapV2(int[] inputs) {
    Map<Integer, Integer> uniqueInputs = new HashMap<>();
    for (int input : inputs) {
      if (uniqueInputs.put(input, input) != null) {
        //Returns null if the input is new otherwise return the Value
        return true;
      }
    }

    return false;
  }

}
