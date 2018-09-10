package com.leetcode.problems;

/**
 * Created by satyajit on 9/10/18.
 */
public class LPS {

  public static String longestPalindrome(String s) {
    String result = "", palindrom = "";
    int index = 0;

    while (index < s.length()) {
      int end = findStopIndex(index, s);
      if (index == end && index == 0) {
        palindrom = s.charAt(index) + "";
        /*index++;
        continue;*/
      } else if (index == end && index > 0) {
        int i = index - 1;
        int j = index + 1;
        while (i >= 0 && j < s.length()) {
          if (s.charAt(i) != s.charAt(j)) {
            break;
          }

          palindrom = s.substring(i, j + 1);
          i--;
          j++;
        }

      } else {
        palindrom = s.substring(index, end + 1);
        int i = index == 0 ? 0 : index - 1;
        //end = end == 0 ? 0 : end - 1;
        int j = end == s.length() - 1 ? s.length() - 1 : end + 1;

        while (i >= 0 && j < s.length()) {
          if (s.charAt(i) != s.charAt(j)) {
            break;
          }
          palindrom = s.substring(i, j + 1);
          i--;
          j++;
        }
      }

      if (palindrom.length() > result.length()) {
        result = palindrom.substring(0, palindrom.length());
      }

      index++;
    }

    return result;
  }

  private static int findStopIndex(int start, String s) {
    int index = start;
    int end = start;
    while (index < s.length() - 1) {
      if (s.charAt(index) != s.charAt(index + 1)) {
        break;
      }

      end++;
      index++;
    }

    return end;
  }

  public static void main(String[] args) {
    System.out.println(longestPalindrome("madamaamadam"));
    System.out.println(longestPalindrome("aabbaa"));
    System.out.println(longestPalindrome("cbbd"));
  }
}
