package com.leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

public class GenerateParentheses {

  public List<String> generateParenthesis(int n) {
    List<String> ans = new ArrayList();
    backtrack(ans, "", 0, 0, n);
    return ans;
  }

  public void backtrack(List<String> ans, String cur, int open, int close, int max) {
    if (cur.length() == max * 2) {
      ans.add(cur);
      return;
    }

    if (open < max) {
      backtrack(ans, cur + "(", open + 1, close, max);
    }
    if (close < open) {
      backtrack(ans, cur + ")", open, close + 1, max);
    }
  }

  public static void main(String[] args) {
    GenerateParentheses generateParentheses = new GenerateParentheses();
    //System.out.println(generateParentheses.isValid("(())))()"));
    List<String> parenthesis = generateParentheses.generateParenthesis(2);
    parenthesis.forEach(System.out::println);
  }
}
