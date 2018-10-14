package com.leetcode.problems;

public class RotateImage {

  public void rotate(int[][] matrix) {
    int n = matrix.length;
    for (int i = 0; i < n / 2; i++) {

      int nMovements = 4 * (n - 1 - i);
      int nextI = i;
      int nextJ = i;
      int toMove = matrix[nextI][nextJ];
      for (int j = 0; j < nMovements; j++) {

        if (nextJ + 1 > (n - 1) && nextI < (n - 1)) {
          nextI++;
        } else if (nextI + 1 > (n - 1) && nextJ > 0) {
          nextJ--;
        } else if (nextJ - 1 < 0 && nextI > 0) {
          nextI--;
        } else {
          nextJ++;
        }

        int temp = matrix[nextI][nextJ];
        matrix[nextI][nextJ] = toMove;
        toMove = temp;
      }
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
  /*  int[][] matrix = {
        {1, 2},
        {3, 4}
    };*/
    int[][] matrix = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };
    //instance.printMatrix(matrix);
    instance.rotate(matrix);
    instance.printMatrix(matrix);
  }

}
