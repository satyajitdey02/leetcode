package com.leetcode.problems;

import java.util.Stack;

public class ValidParentheses {

  public boolean isValid(String s) {
    if (s.isEmpty()) {
      return true;
    }

    if (s.indexOf('(') < 0 && s.indexOf(')') < 0
        && s.indexOf('{') < 0 && s.indexOf('}') < 0
        && s.indexOf('[') < 0 && s.indexOf(']') < 0) {
      return false;
    }

    if (s.length() % 2 != 0) {
      return false;
    }

    Stack<Character> parenthesis = new Stack<>();
    for (Character c : s.toCharArray()) {
      if (c == '(' || c == '{' || c == '[') {
        parenthesis.push(c);
        continue;
      }

      if (c == ')' && !parenthesis.empty() && parenthesis.peek() == '(') {
        parenthesis.pop();
        continue;
      }

      if (c == '}' && !parenthesis.empty() && parenthesis.peek() == '{') {
        parenthesis.pop();
        continue;
      }

      if (c == ']' && !parenthesis.empty() && parenthesis.peek() == '[') {
        parenthesis.pop();
        continue;
      }
    }

    return parenthesis.empty();
  }

  public static void main(String[] args) {
    ValidParentheses validParentheses = new ValidParentheses();
    System.out.println(validParentheses.isValid("){"));
  }
}
