package leetcode.linkedlist;

import common.ListNode;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * For example,
 * Given1->2->3->3->4->4->5, return1->2->5.
 * Given1->1->1->2->3, return2->3.
 */
public class Exercise66 {

    public static void main(String[] args) {
        Exercise66 exe = new Exercise66();
//        ListNode list = ListNode.create(1, 2, 3, 3, 4, 4, 5);
        ListNode list = ListNode.create(1, 1, 1, 2, 3);
        System.out.println(exe.deleteDuplicates(list).toString());
    }


    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode seeker1 = head;
        ListNode seeker2 = head.next;
        while (seeker2 != null) {
            if (seeker1.val == seeker2.val) {
                while (seeker2.next != null && seeker2.next.val == seeker1.val) {
                    seeker2 = seeker2.next;
                }
                pre.next = seeker2.next;
                seeker1 = seeker2.next;
                if (seeker1 == null) {
                    return dummy.next;
                }
                seeker2 = seeker1.next;
            } else {
                pre = seeker1;
                seeker1 = seeker2;
                seeker2 = seeker2.next;
            }
        }
        return dummy.next;

    }

}
