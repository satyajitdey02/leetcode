package com.leetcode.problems;

public class RemoveNthNode {

  public ListNode removeNthFromEnd(ListNode head, int n) {

    int listSize = getListSize(head);
    if (n < 1) {
      return head;
    }

    if (listSize == n) {
      return head.next;
    }

    ListNode node = head;
    ListNode prev = null;
    while (node != null) {

      if (listSize == n) {
        prev.next = node.next;
        break;
      }

      prev = node;
      node = node.next;
      listSize--;
    }

    return head;
  }

  private int getListSize(ListNode head) {
    int size = 0;
    ListNode node = head;
    while (node != null) {
      size++;
      node = node.next;
    }
    return size;
  }

  public static void main(String[] args) {
    ListNode n1 = new ListNode(1);
    ListNode n2 = new ListNode(2);
    ListNode n3 = new ListNode(3);
    ListNode n4 = new ListNode(4);
    ListNode n5 = new ListNode(5);

    n1.next = n2;
    n2.next = n3;
    n3.next = n4;
    n4.next = n5;

    ListNode result = new RemoveNthNode().removeNthFromEnd(n1, 2);
    System.out.println(result);
  }
}
