package leetcode.sort;

import common.ListNode;

/**
 * Sort a list list in O(n log n) time using constant space complexity.
 */
public class Exercise4 {

    public static class Solution {

        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode mid = findMiddle(head);
            ListNode right = sortList(mid.next);
            mid.next = null;
            ListNode left = sortList(head);
            return merge(left, right);
        }

        public ListNode findMiddle(ListNode list) {
            ListNode slow = list;
            ListNode fast = list.next;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

        private ListNode merge(ListNode left, ListNode right) {
            ListNode list = new ListNode(0);
            ListNode head = list;
            while (left != null && right != null) {
                if (left.val > right.val) {
                    head.next = right;
                    right = right.next;
                } else {
                    head.next = left;
                    left = left.next;
                }
                head = head.next;
            }
            if (left != null) {
                head.next = left;
            }
            if (right != null) {
                head.next = right;
            }
            return list.next;
        }
    }

}
