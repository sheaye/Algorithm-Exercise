package leetcode.list;

import common.ListNode;

/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln →L1→Ln-1→L2→Ln-2→…
 * You must do this in-place without altering the nodes' values.
 * For example,
 * Given{1,2,3,4}, reorder it to{1,4,2,3}.
 */
public class Exercise8 {

    public static void main(String[] args) {
        Exercise8 exe = new Exercise8();
        int[] arr = {1, 2, 3, 4, 5, 6};
        ListNode list = ListNode.create(arr);
        exe.reorderList3(list);
        System.out.println(list.toString());
    }

    public void reorderList2(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode secondLast = head;
        while (secondLast.next.next != null) {
            secondLast = secondLast.next;
        }
        ListNode last = secondLast.next;
        secondLast.next = null;

        last.next = head.next;
        head.next = last;
        reorderList2(head.next.next);
    }

    public void reorderList3(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode mid = findMid(head);
        ListNode tail = reverse(mid.next);
        mid.next = null;
        merge(head, tail);
    }

    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode list) {
        ListNode cur = list;
        ListNode pre = cur.next;
        cur.next = null;
        while (pre != null) {
            ListNode temp = pre.next;// 保存pre以后部分
            pre.next = cur;// 将pre置于cur头部
            cur = pre;// cur引用指向新的cur头部
            pre = temp;// pre向后移动一位
        }
        return cur;
    }

    private void merge(ListNode head, ListNode tail) {
        while (tail != null) {
            ListNode temp = tail.next;
            tail.next = head.next;
            head.next = tail;
            tail = temp;
            head = head.next.next;
        }
    }

}
