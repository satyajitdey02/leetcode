package com.leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class GenerateParentheses {

  public List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<>();

    List<String> listP = new ArrayList<>();
    List<String> listN = new ArrayList<>();

    List<String> generatedParenthesis = new ArrayList<>();
    generateKLengthStr("", n, generatedParenthesis);

    for (String s : generatedParenthesis) {
      int strVal = getStrVal(s);
      if (strVal == 0) {
        listP.add(s);
        listN.add(s);
      } else if (strVal > 0 && s.startsWith("(")) {
        listP.add(s);
      } else {
        listN.add(s);
      }
    }

    Set<String> mergedString = new HashSet<>();
    for (String sp : listP) {
      if (!sp.startsWith("(")) {
        continue;
      }
      for (String sn : listN) {
        if (!sn.endsWith(")")) {
          continue;
        }
        mergedString.add(sp + sn);
      }
    }

    for (String s : mergedString) {
      int strVal = getStrVal(s);
      if (strVal == 0) {
        result.add(s);
      }
    }

    return result;
  }

  private int getStrVal(String s) {
    Map<Character, Integer> map = new HashMap<Character, Integer>() {
      {
        put('(', 1);
        put(')', -1);
      }
    };

    int strVal = 0;
    for (int i = 0; i < s.length(); i++) {
      strVal += map.get(s.charAt(i));
    }

    return strVal;
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
//["(((())))","((()()))","((())())","((()))()","(()(()))","(()()())","(()())()","(())(())","(())()()","()((()))","()(()())","()(())()","()()(())","()()()()"]
    GenerateParentheses generateParentheses = new GenerateParentheses();
    List<String> parenthesis = generateParentheses.generateParenthesis(3);//new ArrayList<>();
    // generateParentheses.generateKLengthStr("", 3, parenthesis);
    parenthesis.forEach(System.out::println);
  }
}
