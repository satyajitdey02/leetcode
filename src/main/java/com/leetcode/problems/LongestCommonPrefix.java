package com.leetcode.problems;

import java.util.Arrays;
import java.util.Collections;

public class LongestCommonPrefix {

  public String longestCommonPrefix(String[] strs) {
    if (strs.length == 0) {
      return "";
    }

    if (strs.length == 1) {
      return strs[0];
    }

    String firstStr = strs[0];
    while (firstStr.length() != 0) {
      boolean found = true;
      for (int i = 1; i < strs.length; i++) {
        if (strs[i].indexOf(firstStr) != 0) {
          found = false;
          break;
        }
      }

      if (found) {
        return firstStr;
      }

      firstStr = firstStr.substring(0, firstStr.length() - 1);
    }

    return "";
  }

  public static void main(String[] args) {
    LongestCommonPrefix prefix = new LongestCommonPrefix();
    //System.out.println(prefix.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    System.out.println(prefix.longestCommonPrefix(new String[]{"c", "acc", "ccc"}));
  }

}
