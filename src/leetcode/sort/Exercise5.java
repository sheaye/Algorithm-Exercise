package leetcode.sort;

import common.ListNode;

/**
 * Sort a list list using insertion sort.
 */
public class Exercise5 {

    public static void main(String[] args) {
        Exercise5 exe = new Exercise5();
        int[] array = {1, 3, 5, 2, 4, 6};
        System.out.println(exe.insertionSortList2(ListNode.create(array)));
    }

    public ListNode insertionSortList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        ListNode temp;
        dummyHead.next = insertionSortList2(head.next);
        temp = dummyHead;
        while (temp != null && temp.next != null && head.val > temp.next.val) {
            temp = temp.next;
        }
        head.next = temp.next;
        temp.next = head;
        return dummyHead.next;
    }

    public ListNode insertionSortList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode sorted = new ListNode(Integer.MIN_VALUE);
        ListNode temp;
        while (head != null) {
            temp = head.next;
            head.next = null;
            sorted = insertionSort(sorted, head);
            head = temp;
        }

        return sorted.next;
    }

    private ListNode insertionSort(ListNode sorted, ListNode next) {
        if (sorted.next == null) {
            if (next.val > sorted.val) {
                sorted.next = next;
                return sorted;
            } else {
                next.next = sorted;
                return next;
            }
        }
        ListNode mid = findMiddle(sorted);
        if (next.val > mid.val) {
            mid.next = insertionSort(mid.next, next);
            return sorted;
        } else {
            ListNode temp = mid.next;
            mid.next = null;
            ListNode head = insertionSort(sorted, next);
            mid.next = temp;
            return head;
        }
    }

    private ListNode findMiddle(ListNode start) {
        ListNode slow = start;
        ListNode fast = start.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
