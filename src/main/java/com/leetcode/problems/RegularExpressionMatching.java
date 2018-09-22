package com.leetcode.problems;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionMatching {
  public boolean isMatch(String s, String p) {
    Pattern pattern = Pattern.compile(p);
    Matcher matcher = pattern.matcher(s);
    return matcher.matches();
  }

  public static void main(String[] args) {
    RegularExpressionMatching matching = new RegularExpressionMatching();
    System.out.println(matching.isMatch("aa", "a"));
    System.out.println(matching.isMatch("ab", ".*"));
    System.out.println(matching.isMatch("aab", "c*a*b"));
    System.out.println(matching.isMatch("mississippi", "mis*is*p*."));
  }
}
