package leetcode.linkedlist;

import common.ListNode;

/**
 * Given a linked linkedlist, return the node where the cycle begins. If there is no cycle, return null.
 * Follow up:
 * Can you solve it without using extra space?
 */
public class Exercise9 {

    public static void main(String[] args) {
        int[] arr = {-21, 10, 17, 8, 4, 26, 5, 35, 33, -7, -16, 27, -12, 6, 29, -12, 5, 9, 20, 14, 14, 2, 13, -24, 21, 23, -21, 5};
        ListNode list = ListNode.create(arr);
        ListNode temp = list;
        ListNode circle0 = null;
        int index = 0;
        while (temp.next != null) {
            if (index++ == 24) {
                circle0 = temp;
            }
            temp = temp.next;
        }
        temp.next = circle0;
        System.out.println(list.toString());
        Exercise9 exe = new Exercise9();
        System.out.println(exe.detectCycle(list));
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode quick = head;
        while (quick != null && quick.next != null) {
            slow = slow.next;
            quick = quick.next.next;
            if (slow == quick) {
                quick = head;
                while (slow != quick) {
                    slow = slow.next;
                    quick = quick.next;
                }
                return slow;
            }
        }
        return null;

    }


}
