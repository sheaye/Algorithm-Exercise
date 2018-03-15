package offer66;

import common.ListNode;

/**
 * 一个链表中包含环，请找出该链表的环的入口结点。
 */
public class Exercise55 {

    /*public ListNode EntryNodeOfLoop(ListNode pHead) {
        Set<ListNode> set = new HashSet<>();
        set.add(pHead);
        while (pHead.next != null) {
            pHead = pHead.next;
            if (set.contains(pHead)) {
                return pHead;
            } else {
                set.add(pHead);
            }
        }
        return null;
    }*/

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null || pHead.next.next == null) {
            return null;
        }
        ListNode slow = pHead.next;
        ListNode fast = slow.next;
        while (fast != slow) {
            if (slow != null && fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            } else {
                return null;
            }
        }
        fast = pHead;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
