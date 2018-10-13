package com.leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidSudoku {

  public boolean isValidSudoku(char[][] board) {
    Map<String, Character> sudokuMap = new HashMap<>();
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (board[i][j] == '.') {
          continue;
        }

        int subBox = findSubBox(i, j);
        StringBuilder sb = new StringBuilder();
        sb.append(i).append(j).append(subBox);
        List<String> coords = getKeysforValue(board[i][j], sudokuMap);
        if (coords == null) {
          sudokuMap.put(sb.toString(), board[i][j]);
          continue;
        }

        for (String coord : coords) {
          if ((i == coord.charAt(0) - 48) || (j == coord.charAt(1) - 48)
              || (subBox == coord.charAt(2) - 48)) {
            return false;
          }
        }

        sudokuMap.put(sb.toString(), board[i][j]);

      }
    }

    return true;
  }

  private List<String> getKeysforValue(Character value, Map<String, Character> map) {
    if (!map.containsValue(value)) {
      return null;
    }

    List<String> keys = new ArrayList<>();
    for (Map.Entry<String, Character> entry : map.entrySet()) {
      if (entry.getValue() == value) {
        keys.add(entry.getKey());
      }
    }
    return keys;
  }

  private int findSubBox(int i, int j) {

    if (i >= 0 && i < 3 && j >= 0 && j < 3) {
      return 0;
    }

    if (i >= 3 && i < 6 && j >= 0 && j < 3) {
      return 1;
    }

    if (i >= 6 && i < 9 && j >= 0 && j < 3) {
      return 2;
    }

    if (i >= 0 && i < 3 && j >= 3 && j < 6) {
      return 3;
    }

    if (i >= 3 && i < 6 && j >= 3 && j < 6) {
      return 4;
    }

    if (i >= 6 && i < 9 && j >= 3 && j < 6) {
      return 5;
    }

    if (i >= 0 && i < 3 && j >= 6 && j < 9) {
      return 6;
    }

    if (i >= 3 && i < 6 && j >= 6 && j < 9) {
      return 7;
    }

    if (i >= 6 && i < 9 && j >= 6 && j < 9) {
      return 8;
    }

    return -1;
  }


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
  }

}
