package com.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsPhoneNumber {

  public List<String> letterCombinations(String digits) {

    Map<Integer, String> digitToStrMap = new HashMap<Integer, String>() {
      {
        put(2, "abc");
        put(3, "def");
        put(4, "ghi");
        put(5, "jkl");
        put(6, "mno");
        put(7, "pqrs");
        put(8, "tuv");
        put(9, "wxyz");
      }
    };

    StringBuilder sb = new StringBuilder();
    for (char digit : digits.toCharArray()) {
      if (digitToStrMap.containsKey(Character.getNumericValue(digit))) {
        sb.append(digit);
      }
    }

    if (sb.toString().isEmpty()) {
      return Collections.EMPTY_LIST;
    }

    List<String> combinations = new ArrayList<>();
    for (char c : sb.toString().toCharArray()) {
      String[] current = digitToStrMap.get(Character.getNumericValue(c)).split("");
      List<String> currentDigitStrs = Arrays.asList(current);

      if (combinations.size() == 0) {
        combinations.addAll(currentDigitStrs);
        continue;
      }

      List<String> tempList = new ArrayList<>(combinations);
      combinations = new ArrayList<>();
      for (String sp : tempList) {
        for (String cs : currentDigitStrs) {
          combinations.add(sp + cs);
        }
      }
    }

    return combinations;
  }

  public static void main(String[] args) {
    LetterCombinationsPhoneNumber instance = new LetterCombinationsPhoneNumber();
    System.out.println(instance.letterCombinations("234"));
  }

}
