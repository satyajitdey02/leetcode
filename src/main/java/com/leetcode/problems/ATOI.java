package com.leetcode.problems;


public class ATOI {

  public int myAtoi(String str) {
    if (str == null) {
      return 0;
    }

    String trimmedStr = str.trim();
    if (trimmedStr.isEmpty()) {
      return 0;
    }

    char firstChar = trimmedStr.charAt(0);
    if (!Character.isDigit(firstChar) && firstChar != '+' && firstChar != '-') {
      return 0;
    }

    String strToExamine = trimmedStr;
    char sign = '+';
    if (firstChar == '+' || firstChar == '-') {
      sign = firstChar;
      strToExamine = trimmedStr.substring(1);
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < strToExamine.length(); i++) {
      if (!Character.isDigit(strToExamine.charAt(i))) {
        break;
      }

      sb.append(strToExamine.charAt(i));
    }

    if (sb.toString().isEmpty()) {
      return 0;
    }

    String numString = sign + sb.toString();
    try {
      return Integer.parseInt(numString);
    } catch (NumberFormatException nfe) {
      if (trimmedStr.charAt(0) == '-') {
        return Integer.MIN_VALUE;
      }

      return Integer.MAX_VALUE ;
    }
  }

  public static void main(String[] args) {
    ATOI atoi = new ATOI();
    System.out.println(atoi.myAtoi("2147483648"));
    System.out.println(atoi.myAtoi("+-"));
    System.out.println("+42-->" + atoi.myAtoi("+42"));
    System.out.println("-42-->" + atoi.myAtoi("-42"));
    System.out.println("4193 with words-->" + atoi.myAtoi("4193 with words"));
    System.out.println("words and 987-->" + atoi.myAtoi("words and 987"));
    System.out.println("-91283472332-->" + atoi.myAtoi("-91283472332"));
    System.out.println("+9128347233234-->" + atoi.myAtoi("+9128347233234"));
  }

}
