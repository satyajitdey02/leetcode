package com.leetcode.problems;

public class CountAndSay {

  public String countAndSay(int n) {
    return countAndSay("1", 1, n);
  }

  private String countAndSay(String s, int round, int n) {
    String genStr = "";
    if (round == n) {
      return s;
    } else if (s.length() == 1) {
      genStr = countAndSay(1 + s, round + 1, n);
    } else {
      int count = 1;
      String say = "";
      for (int i = 0; i < s.length(); i++) {
        if (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
          count++;
        } else {
          say = say + count + s.charAt(i);
          count = 1;
        }
      }

      genStr = countAndSay(say, round + 1, n);
    }

    return genStr;
  }

  public static void main(String[] args) {
    System.out.println(new CountAndSay().countAndSay(6));
  }
}
