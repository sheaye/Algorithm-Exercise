package jianzhioffer;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class Exercise14 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k < 1) {
            return null;
        }
        int size = 1;
        ListNode temp = head;
        while (temp.next != null) {
            size++;
            temp = temp.next;
        }
        if (k > size) {
            return null;
        } else if (k == size) {
            return head;
        }
        int index = 0;
        while (head.next != null) {
            index++;
            if (index == size - k) {
                return head.next;
            }
            head = head.next;
        }
        return null;
    }

    public ListNode FindKthToTail2(ListNode head, int k) {
        if (head == null || k < 1) {
            return null;
        }
        ListNode header = head;
        ListNode tail = head;
        for (int i = 1; i < k; i++) {
            if (header.next != null) {
                header = header.next;
            }else {
                return null;
            }
        }
        while (header.next!=null){
            header = header.next;
            tail = tail.next;
        }
        return tail;
    }

}
