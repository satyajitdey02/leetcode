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

    Arrays.sort(strs, (s1, s2) -> s1.length() - s2.length());

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < strs[0].length(); i++) {
      char str0Char = strs[0].charAt(i);
      for (int j = 1; j < strs.length; j++) {
        if (strs[j].charAt(i) != str0Char) {
          return sb.toString();
        }
      }
      sb.append(str0Char);
    }

    return sb.toString();
  }

  public static void main(String[] args) {
    LongestCommonPrefix prefix = new LongestCommonPrefix();
    //System.out.println(prefix.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    System.out.println(prefix.longestCommonPrefix(new String[]{"c", "c", ""}));
  }

}
