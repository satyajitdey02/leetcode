package com.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

  public int romanToInt(String s) {
    int result = 0;
    Map<Character, Integer> romanToIntMap = new HashMap<Character, Integer>() {
      {
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
      }
    };

    for (int i = 0; i < s.length(); i++) {
      Integer currentVal = romanToIntMap.get(s.charAt(i));
      if (i < s.length() - 1 && currentVal < romanToIntMap.get(s.charAt(i + 1))) {
        result = result - currentVal;
      } else {
        result = result + currentVal;
      }
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(new RomanToInteger().romanToInt("MCMXCIV"));
  }
}
