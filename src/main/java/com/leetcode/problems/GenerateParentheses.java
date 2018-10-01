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
    List<String> result = new ArrayList<>();

    List<String> generatedParenthesis = new ArrayList<>();
    generateKLengthStr("", n, generatedParenthesis);

    Set<String> mergedString = new HashSet<>();
    for (String is : generatedParenthesis) {
      for (String js : generatedParenthesis) {
        String ms = is + js;
        if (isValid(ms)) {
          mergedString.add(ms);
        }
      }
    }

    result.addAll(mergedString);
    return result;
  }

  private boolean isValid(String s) {
    if (s.isEmpty()) {
      return true;
    }

    if (s.length() % 2 != 0) {
      return false;
    }

    if (s.startsWith(")")) {
      return false;
    }

    Stack<Character> parenthesis = new Stack<>();
    for (Character c : s.toCharArray()) {
      if (c == '(') {
        parenthesis.push(c);
        continue;
      }

      if (parenthesis.empty() && c == ')') {
        return false;
      }

      if ((c == ')' && parenthesis.peek() == '(')) {
        parenthesis.pop();
        continue;
      }
    }

    return parenthesis.empty();
  }

  private void generateKLengthStr(String prefix, int k, List<String> parenthesis) {
    final char[] chars = {'(', ')'};
    if (k == 0) {
      parenthesis.add(prefix);
      return;
    }

    for (int i = 0; i < chars.length; i++) {
      generateKLengthStr(prefix + chars[i], k - 1, parenthesis);
    }
  }

  public static void main(String[] args) {
    GenerateParentheses generateParentheses = new GenerateParentheses();
    //System.out.println(generateParentheses.isValid("(())))()"));
    List<String> parenthesis = generateParentheses.generateParenthesis(4);
    parenthesis.forEach(System.out::println);
  }
}
