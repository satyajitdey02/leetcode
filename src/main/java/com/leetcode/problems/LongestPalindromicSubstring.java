package com.leetcode.problems;

public class LongestPalindromicSubstring {

  public String longestPalindrome(String s) {
    String result = "";
    int index = 0;
    String palindrom = "";
    while (index < s.length()) {
      StringBuilder sb = new StringBuilder();
      //palindrom = s.substring(index,index+1);
      int k = index;

      while (k < s.length()) {
        if (k + 1 >= s.length()) {
          break;
        }

        if (s.charAt(k) != s.charAt(k + 1)) {
          break;
        }

        sb.append(s.charAt(k));
        k++;
      }

      if (sb.toString().length() > 0) {
        sb.append(s.charAt(k));
        palindrom = sb.toString();
        index = k;//index + palindrom.length();
      }


      int leftIndex = index - sb.toString().length();
      int rightIndex = index + sb.toString().length()-1;
      if(rightIndex < 0) {
        rightIndex = 0;
      }
      if (index >= sb.toString().length() && index < s.length() && s.charAt(leftIndex) == s.charAt(rightIndex)) {

        //int from = index - sb.toString().length();
       // int to = (index + sb.toString().length()) + 1;
        palindrom = s.substring(leftIndex, rightIndex+1);

        int i = index - 2;
        int j = index + 2+sb.toString().length();
        while (i >= 0 && j < s.length()) {
          if (s.charAt(i) != s.charAt(j)) {
            break;
          }

          palindrom = s.substring(i, j + 1);
          i--;
          j++;

        }
      }

      result = result.length() < palindrom.length() ? palindrom : result;
      index++;
    }

    return result;
  }

  public static void main(String[] args) {
    LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
    System.out.println(longestPalindromicSubstring.longestPalindrome("allpadapllagogabamabagog"));
    System.out.println(longestPalindromicSubstring.longestPalindrome("alla"));
  }
}
