package com.leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenerateParentheses {

  public List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<>();

    Map<Character, Integer> map = new HashMap<Character, Integer>() {
      {
        put('(', 1);
        put(')', 1);
      }
    };

    List<String> left = new ArrayList<>();
    for (int i = 0; i < Math.pow(2, n); i++) {
      StringBuilder row = new StringBuilder();
      for (int j = 0; j < n; j++) {
        if (i % 2 == 0) {
          row.append('(');
        } else {
          row.append(')');
        }
      }

    }

    List<String> right = new ArrayList<>();

    return result;
  }

  public static void main(String[] args) {
    List<String> result = new GenerateParentheses()
        .generateParenthesis(3);
    result.forEach(System.out::println);
  }
}
