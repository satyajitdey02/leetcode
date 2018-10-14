package com.leetcode.problems;

public class RotateImage {

  public void rotate(int[][] matrix) {
    int n = matrix.length;
    for (int i = 0; i < n / 2; i++) {

      for (int k = 0; k < (n - 1 - 2 * i); k++) {
        int nMovements = 4 * (n - 1 - 2 * i);
        int nextI = i;
        int nextJ = i;
        int toMove = matrix[nextI][nextJ];
        for (int j = 0; j < nMovements; j++) {

          if (((nextJ + 1) > (n - 1 - i)) && (nextI < (n - 1 - i))) {
            nextI++;
          } else if (((nextI + 1) > (n - 1 - i)) && (nextJ > i)) {
            nextJ--;
          } else if (((nextJ - 1) < i) && (nextI > i)) {
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
    int[][] matrix1 = {
        {1, 2},
        {3, 4}
    };
    test1(matrix1);

    int[][] matrix2 = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };
    test1(matrix2);

    int[][] matrix3 = {
        {5, 1, 9, 11},
        {2, 4, 8, 10},
        {13, 3, 6, 7},
        {15, 14, 12, 16}
    };
    test1(matrix3);
  }

  private static void test1(int[][] input) {
    RotateImage instance = new RotateImage();

    instance.printMatrix(input);
    instance.rotate(input);
    instance.printMatrix(input);
  }

}
