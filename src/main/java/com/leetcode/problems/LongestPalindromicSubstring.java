package com.leetcode.problems;

public class LongestPalindromicSubstring {

  public String longestPalindrome(String s) {
    int index = 0;
    String palindrom = "";
    while (index < s.length()) {
      if (index > 0 && index < s.length() - 1) {
        if (s.charAt(index - 1) == s.charAt(index + 1)) {
          palindrom = s.substring(index - 1, (index + 1) + 1);
          int i = index - 2;
          int j = index + 2;
          while (i >= 0 && j < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
              palindrom = s.substring(i, j + 1);
            }

            i--;
            j++;
          }
        }
      }

      index++;
    }

    return palindrom;
  }

  public static void main(String[] args) {
    LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
    System.out.println(longestPalindromicSubstring.longestPalindrome("allpadapgoog"));
  }
}
