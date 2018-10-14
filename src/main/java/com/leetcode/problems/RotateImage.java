package com.leetcode.problems;

public class RotateImage {

  public void rotate(int[][] matrix) {
    int N = matrix.length;
    for (int offset = 0; offset <= N / 2; ++offset) {
      for (int i = offset; i < N - offset - 1; ++i) {
        int t = matrix[offset][i];
        matrix[offset][i] = matrix[N - 1 - i][offset];
        matrix[N - 1 - i][offset] = matrix[N - 1 - offset][N - 1 - i];
        matrix[N - 1 - offset][N - 1 - i] = matrix[i][N - 1 - offset];
        matrix[i][N - 1 - offset] = t;
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
