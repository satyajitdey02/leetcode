package com.leetcode.problems;

/**
 * Created by satyajit on 9/10/18.
 */
public class LPS {

  public static String longestPalindrome(String s) {
    String result = "", palindrom;
    int index = 0;

    while (index < s.length()) {
      if (index % 2 == 0) {
        palindrom = extractPalindrom(index - 1, index + 1, s);
      } else {

        palindrom = extractPalindrom(index, index + 1, s);
      }

      if (palindrom.length() > result.length()) {
        result = palindrom.substring(0, palindrom.length());
      }

      index++;
    }

    return result;
  }

  private static String extractPalindrom(int i, int j, String s) {
    String palindrom = "";
    while (i >= 0 && j < s.length()) {
      if (s.charAt(i) != s.charAt(j)) {
        return palindrom;
      }

      palindrom = s.substring(i, j + 1);
      i--;
      j++;
    }

    return palindrom;
  }

  public static void main(String[] args) {
    //System.out.println(longestPalindrome("madam"));
    System.out.println(longestPalindrome("aabbaa"));
  }
}
