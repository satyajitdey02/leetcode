package com.leetcode.practice;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
//63500857142
//112151550897
public class Solution {

  /*
   * Complete the circularPalindromes function below.
   */
  static int[] circularPalindromes(String s) {
    int[] result = new int[s.length()];
    for (int i = 0; i < s.length(); i++) {
      String str = s.substring(i, s.length()) + s.substring(0, i);
      String palindrom = longestPalindrome(str);
      result[i] = palindrom.length();
    }

    return result;
  }

  private static String longestPalindrome(String s) {
    String result = "", palindrom = "";
    int index = 0;

    while (index < s.length()) {
      int end = findStopIndex(index, s);
      if (index == end && index == 0) {
        palindrom = s.charAt(index) + "";
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

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter =
        new BufferedWriter(
            new FileWriter("/home/satyajit/Development/leetcode/src/main/resources/output.txt"));

    int n = Integer.parseInt(scanner.nextLine().trim());
    // System.out.println(n);
    String s = scanner.nextLine();
    //System.out.println("s = " + s);

    long start = System.nanoTime();
    int[] result = circularPalindromes(s);
    long end = System.nanoTime();
    System.out.println(end-start);

    for (int resultItr = 0; resultItr < result.length; resultItr++) {
      bufferedWriter.write(String.valueOf(result[resultItr]));

      if (resultItr != result.length - 1) {
        bufferedWriter.write("\n");
      }
    }

    bufferedWriter.newLine();

    bufferedWriter.close();
  }
}

