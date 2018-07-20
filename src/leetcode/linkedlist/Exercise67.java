package leetcode.linkedlist;

import common.ListNode;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * For example,
 * Given1->1->2, return1->2.
 * Given1->1->2->3->3, return1->2->3.
 */
public class Exercise67 {

    public static void main(String[] args) {
        Exercise67 exe = new Exercise67();
        System.out.println(exe.deleteDuplicates(ListNode.create(1, 1)));
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val != cur.next.val) {
                pre = cur;
                cur = cur.next;
            } else {
                cur = cur.next;
                pre.next = cur;
            }
        }
        return dummy.next;
    }

}
