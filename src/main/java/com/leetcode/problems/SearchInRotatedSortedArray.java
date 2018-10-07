package com.leetcode.problems;

public class SearchInRotatedSortedArray {

  class Node {

    Key key;
    Node left;
    Node right;

    Node(Key key) {
      this.key = key;
      left = right = null;
    }
  }

  class Key {

    int val;
    int index;

    Key(int val, int index) {
      this.val = val;
      this.index = index;
    }
  }

  private Node convertToBST(int nums[]) {
    Node root = null;
    for (int i = 0; i < nums.length; i++) {
      root = insertToBST(root, new Key(nums[i], i));
    }

    return root;
  }

  private Node insertToBST(Node root, Key key) {
    if (root == null) {
      return new Node(key);
    }

    if (root.key.val < key.val) {
      root.right = insertToBST(root.right, key);
    } else {
      root.left = insertToBST(root.left, key);
    }

    return root;
  }

  private int search(Node root, int value) {
    if (root == null) {
      return -1;
    }

    if (value == root.key.val) {
      return root.key.index;
    } else if (value > root.key.val) {
      return search(root.right, value);
    } else {
      return search(root.left, value);
    }

  }

  public int search(int[] nums, int target) {
    Node root = convertToBST(nums);
    return search(root, target);
  }

  public static void main(String[] args) {
    int nums[] = {4, 5, 6, 7, 0, 1, 2};
    System.out.println(new SearchInRotatedSortedArray().search(nums, 5));
  }

}
