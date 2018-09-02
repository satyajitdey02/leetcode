package com.leetcode.problems;


public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode a2 = new ListNode(4);
       /* ListNode a4 = new ListNode(4);
        ListNode a3 = new ListNode(3);

        a2.next = a4;
        a4.next = a3;*/

        ListNode b5 = new ListNode(7);
        //ListNode b6 = new ListNode(6);
        //ListNode b4 = new ListNode(4);

        //b5.next = b6;
        //b6.next = b4;

        ListNode result = new AddTwoNumbers().addTwoNumbers(a2, b5);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }

    }

    /*
    Input:(2->4->3)+(5->6->4)
    Output:7->0->8
    Explanation:342+465=807.*/
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;

       // l1 = addNodeAtTail(l1, new ListNode(0));
      //  l2 = addNodeAtTail(l2, new ListNode(0));

        int n1Size = listSize(l1);
        int n2Size = listSize(l2);

        int diff = 0;
        if (n1Size >= n2Size) {
            diff = n1Size - n2Size;
            for (int i = 0; i < diff; i++) {
                l2 = addNodeAtTail(l2, new ListNode(0));
            }
        } else {
            diff = n2Size - n1Size;
            for (int i = 0; i < diff; i++) {
                l1 = addNodeAtTail(l1, new ListNode(0));
            }
        }

        int carry = 0;
        do {

            int sum = (carry + l1.val + l2.val) % 10;
            carry = (carry + l1.val + l2.val) / 10;

            ListNode node = new ListNode(sum);
            l1 = l1.next;
            l2 = l2.next;

            result = addNodeAtTail(result, node);
        } while (l1 != null && l2 != null);
        if (carry > 0) {
            result = addNodeAtTail(result, new ListNode(carry));
        }

        return result;
    }

    private ListNode addNodeAtHead(ListNode head, ListNode node) {
        if (head == null) {
            head = node;
            return head;
        }

        ListNode first = head;
        node.next = first;
        head = node;

        return head;
    }

    private ListNode addNodeAtTail(ListNode head, ListNode node) {
        if (head == null) {
            head = node;
            return head;
        }

        ListNode last = head;
        while (last.next != null) {
            last = last.next;
        }

        last.next = node;
        return head;
    }

    private int listSize(ListNode node) {
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }

        return count;
    }

    private int listSizeDiff(ListNode n1, ListNode n2) {
        int n1Size = listSize(n1);
        int n2Size = listSize(n2);

        if (n1Size >= n2Size) {
            return n1Size - n2Size;
        } else {
            return n2Size - n1Size;
        }
    }
}
