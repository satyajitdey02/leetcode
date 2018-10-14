package com.leetcode.problems;

public class RotateImage {

  public void rotate(int[][] matrix) {
    int n = matrix.length;
    int previous = matrix[1][0], temp;
    for (int i = 0; i < n; i++) {
      int nMovements = 4 * (n - 1 - i);
      for (int j = i; j < nMovements; j++) {
        int nextI = i;
        int nextJ = j + 1;

        if (i == n - 1 && j == n - 1) {
          nextJ = j - 1;
        } else if (i == n - 1 && j == 0) {
          nextI = i - 1;
        } else if (i == 0 && j == 0) {
          nextJ = 1;
        } else if (i == 0 && j == n - 1) {
          nextI = 1;
        }

        int J = j % n;
        temp = matrix[i][J];
        matrix[i][J] = previous;
        previous = temp;
      }

      printMatrix(matrix);
    }
  }

  private void printMatrix(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix.length; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }

    System.out.println("-------------------------");
  }

  public static void main(String[] args) {
    RotateImage instance = new RotateImage();
    int[][] matrix = {
        {1, 2},
        {3, 4}
    };
    /*int[][] matrix = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };*/
    instance.printMatrix(matrix);
    instance.rotate(matrix);
    instance.printMatrix(matrix);
  }

}
