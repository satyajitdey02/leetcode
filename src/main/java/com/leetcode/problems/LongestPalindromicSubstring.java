package com.leetcode.problems;

public class LongestPalindromicSubstring {

  public String longestPalindrome(String s) {
    String result = "";
    int index = 0;
    String palindrom = "";
    while (index < s.length()) {
      char current = s.charAt(index);
      /*if(current == 'm') {
        System.out.println("Current: " + current);
      }*/

      if (index > 0 && index < s.length() - 1) {
        if (s.charAt(index - 1) == s.charAt(index + 1)/* && palindrom.length() <= 3*/) {
          palindrom = s.substring(index - 1, (index + 1) + 1);
          int i = index - 2;
          int j = index + 2;
          while (i >= 0 && j < s.length()) {
            if (s.charAt(i) != s.charAt(j)) {
              break;
            }

            //System.out.println("length: " + (j - i + 1));
            palindrom = s.substring(i, j + 1);
            i--;
            j++;

          }

          result = result.length() < palindrom.length() ? palindrom : result;
        }
      }

      index++;
    }

    return result;
  }

  public static void main(String[] args) {
    LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
    System.out.println(longestPalindromicSubstring.longestPalindrome("allpadapllagogabamabagog"));
  }
}
