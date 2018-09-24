package com.leetcode.problems;


public class MergeSortedList {

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode l1Head = l1;
    ListNode l2Head = l2;
    ListNode mHead = dummy;

    while (l1Head != null || l2Head != null) {
      if (l1Head == null) {
        mHead.next = l2Head;
        break;
      }

      if (l2Head == null) {
        mHead.next = l1Head;
        break;
      }

      if (l1Head.val > l2Head.val) {
        mHead.next = new ListNode(l2Head.val);
        l2Head = l2Head.next;
      } else {
        mHead.next = new ListNode(l1Head.val);
        l1Head = l1Head.next;
      }

      mHead = mHead.next;
    }

    return dummy.next;
  }

  public static void main(String[] args) {
    ListNode a1 = new ListNode(1);
    ListNode a3 = new ListNode(3);
    ListNode a5 = new ListNode(5);
    a1.next = a3;
    a3.next = a5;

    ListNode b2 = new ListNode(2);
    ListNode b4 = new ListNode(4);
    ListNode b6 = new ListNode(6);
    b2.next = b4;
    b4.next = b6;

    ListNode result = new MergeSortedList().mergeTwoLists(a1, b2);
    while (result !=null){
      System.out.println(result.val);
      result = result.next;
    }
  }

}
