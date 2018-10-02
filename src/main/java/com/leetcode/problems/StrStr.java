package com.leetcode.problems;

public class StrStr {

  public int strStr(String haystack, String needle) {
    if (haystack == null || needle == null) {
      throw new NullPointerException();
    }

    if (needle.isEmpty() || needle.equals(haystack)) {
      return 0;
    }

    if (haystack.isEmpty() || needle.length() > haystack.length()) {
      return -1;
    }

    int index = -1;
    int i = 0;
    while (i < haystack.length()) {
      if (haystack.charAt(i) == needle.charAt(0)) {
        index = i;
        if (needle.length() > (haystack.length() - index)) {
          return -1;
        }

        if (haystack.substring(index, index + needle.length()).equals(needle)) {
          return index;
        }

        index = -1;
      }
      i++;
    }

    return index;
  }

  public static void main(String[] args) {
    StrStr instance = new StrStr();
    System.out.println(instance.strStr("mississippi",
        "sippia"));
  }
}
