package com.leetcode.problems;


public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode a2 = new ListNode(4);
        ListNode a4 = new ListNode(7);
        ListNode a3 = new ListNode(3);

        a2.next = a4;
        a4.next = a3;

        ListNode b5 = new ListNode(7);
        ListNode b6 = new ListNode(6);
        ListNode b4 = new ListNode(8);

        b5.next = b6;
        b6.next = b4;

        ListNode result = new AddTwoNumbers().addTwoNumbers(a2, b5);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = null;

        int carry = 0;
        ListNode current = null;
        while (l1 != null || l2 != null) {
            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
            carry = sum / 10;

            result = insert(result, new ListNode(sum % 10));

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (carry > 0) {
            //result.next = new ListNode(carry);
            result = insert(result, new ListNode(carry));
        }


        return result;
    }

    private ListNode insert(ListNode head, ListNode node) {
        if (head == null) {
            return node;
        }

        ListNode last = head;
        while (last.next != null) {
            last = last.next;
        }

        last.next = node;

        return head;
    }
}
