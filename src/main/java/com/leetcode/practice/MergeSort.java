package com.leetcode.practice;

public class MergeSort {

  public void sort(int[] arr, int start, int end) {

    if (end > start) {
      int mid = start + (end - start) / 2;
      sort(arr, start, mid);
      sort(arr, mid + 1, end);

      merge(arr, start, mid, end);
    }


  }

  private void merge(int[] arr, int start, int mid, int end) {
    int[] mergedArr = new int[end - start + 1];
    int lStart = start;
    int rStart = mid + 1;
    int k = 0;

    for (int i = start; i <= end; i++) {
      //int left = arr[lStart];
      //int right = arr[rStart];
      if (lStart > mid) {
        mergedArr[k++] = arr[rStart];
        rStart++;
      } else if (rStart > end) {
        mergedArr[k++] = arr[lStart];
        lStart++;
      } else if (arr[lStart] > arr[rStart]) {
        mergedArr[k++] = arr[rStart];
        //lStart++;
        rStart++;
      } else {
        mergedArr[k++] = arr[lStart];
        lStart++;
      }


    }

    for (int i = 0; i < k; i++) {
      arr[start++] = mergedArr[i];
    }
  }

  public static void main(String[] args) {
    int[] arr = {3, 1, 6, 2/*, 8, 5, 9, 0*/};
    new MergeSort().sort(arr, 0, 3);
    //System.out.println(arr);
    for(int i=0;i<arr.length;i++) {
      System.out.println(arr[i]);
    }
  }

}
