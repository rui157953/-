package com.ryan.algorithm.twoadd;

public class TwoAdd {

    public static void main(String[] args) {
        //[9,9,9,9,9,9,9]
        final ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);
        l1.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next = new ListNode(9);

        //[9,9,9,9]
        final ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);

        ListNode listNode =
                Solution.addTwoNumbers(l1, l2);

        while (listNode != null) {
            System.out.printf(" " + listNode.val);
            listNode = listNode.next;
        }
    }


    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    static class Solution {
        public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode head = null;
            ListNode cur = null;
            boolean flag = false;

            while (l1 != null || l2 != null || flag) {
                int val = 0;

                if (l1 != null) {
                    val += l1.val;
                    l1 = l1.next;
                }

                if (l2 != null) {
                    val += l2.val;
                    l2 = l2.next;
                }

                if (flag) {
                    val += 1;
                }

                if (val > 9) {
                    val = val - 10;
                    flag = true;
                } else {
                    flag = false;

                }
                ListNode node = new ListNode(val);
                if (cur == null) {
                    head = cur = node;
                } else {
                    cur.next = node;
                    cur = node;
                }
            }

//            if (flag && cur != null) {
//                cur.next = new ListNode(1);
//            }

            return head;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
