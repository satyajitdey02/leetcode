package com.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ValidSudoku {

  public static void main(String[] args) {
    ValidSudoku instance = new ValidSudoku();

    char[][] inputs1 = {
        {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
    };
    System.out.println("Input-1:" + instance.isValidSudoku(inputs1));

    char[][] inputs2 = {
        {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
    };
    System.out.println("Input-2:" + instance.isValidSudoku(inputs2));

    char[][] inputs3 = {
        {'.', '.', '4', '.', '.', '.', '6', '3', '.'},
        {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
        {'5', '.', '.', '.', '.', '.', '.', '9', '.'},
        {'.', '.', '.', '5', '6', '.', '.', '.', '.'},
        {'4', '.', '3', '.', '.', '.', '.', '.', '1'},
        {'.', '.', '.', '7', '.', '.', '.', '.', '.'},
        {'.', '.', '.', '5', '.', '.', '.', '.', '.'},
        {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
        {'.', '.', '.', '.', '.', '.', '.', '.', '.'}
    };
    System.out.println("Input-3:" + instance.isValidSudoku(inputs3));
   /* System.out.println(instance.findSubBox(4, 3));
    System.out.println(instance.findSubBox(7, 8));
    System.out.println(instance.findSubBox(3, 5));*/
  }

  public boolean isValidSudoku(char[][] board) {
    Set<String> box = new HashSet<>();

    for (int i = 0; i < 9; i++) {
      Set<Character> rows = new HashSet<>();
      Set<Character> columns = new HashSet<>();

      for (int j = 0; j < 9; j++) {
        if (board[i][j] != '.') {
          if (!rows.add(board[i][j])) {
            return false;
          }

          int subBoxNo = (i / 3) * 3 + (j / 3);
          StringBuilder sb = new StringBuilder();
          sb.append(subBoxNo).append(board[i][j]);
          if (!box.add(sb.toString())) {
            return false;
          }
        }

        if (board[j][i] != '.' && !columns.add(board[j][i])) {
          return false;
        }
      }
    }

    return true;
  }
}
