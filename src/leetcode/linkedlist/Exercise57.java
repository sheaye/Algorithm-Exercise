package leetcode.linkedlist;

import common.ListNode;

/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * For example:
 * Given1->2->3->4->5->NULL, m = 2 and n = 4,
 * return1->4->3->2->5->NULL.
 * Note:
 * Given m, n satisfy the following condition:
 * 1 ≤ m ≤ n ≤ length of list.
 */
public class Exercise57 {

    public static void main(String[] args) {
        Exercise57 exe = new Exercise57();
        System.out.println(exe.reverseBetween(ListNode.create(5), 1, 1).toString());
    }

    public ListNode reverseBetween2(ListNode head, int m, int n) {
        ListNode node = head;
        // 当前节点的索引值
        int index = 0;
        // m之前部分的最后一个节点
        ListNode mLeft = null;
        // 已经调换顺序的部分
        ListNode reversed = null;
        // 遍历过程的当前节点
        ListNode cur = null;
        // 调换顺序部分的最后一个节点
        ListNode reversedLast = null;
        while (node != null) {
            if (++index > n) {
                break;
            }
            if (index > m - 1) {
                // 缓存当前节点
                cur = node;
                // 缓存当前节点的后续节点
                node = node.next;
                // 将cur节点加到reversed首位
                cur.next = reversed;
                // 更新reversed
                reversed = cur;
                if (reversed.next == null) {
                    // 缓存调换顺序部分的最后一个节点
                    reversedLast = reversed;
                }
            } else {
                // 缓存m之前的最后一个节点
                mLeft = node;
                node = node.next;
            }
        }
        if (mLeft != null) {
            // 将调换顺序的部分接到m之前的部分
            mLeft.next = reversed;
        } else {
            // m为1, 整个链表的头部也换成了调换完成后的头节点
            // 遍历完成之后cur节点即位调换完成后的头节点
            head = cur;
        }

        if (reversedLast != null) {
            // 调换顺序后拼接剩下的节点
            reversedLast.next = node;
        }
        return head;
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = pre.next;
        for (int i = 1; i < m; i++) {
            pre = cur;
            cur = cur.next;
        }
        // pre始终是反转部分前面的一个节点
        // cur始终是已反转部分的最后一个节点
        for (int i = m; i < n; i++) {
            // 缓存cur节点的下一节点为temp
            ListNode temp = cur.next;
            // 抠掉temp节点
            cur.next = temp.next;
            // 将temp节点插入到pre和pre.next之间，即反转部分的最前位置
            temp.next = pre.next;
            pre.next = temp;
        }
        return dummy.next;
    }

    public ListNode reverseBetween1(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = pre.next;
        for (int i = 1; i < m; i++) {
            pre = cur;
            cur = cur.next;
        }

        System.out.println("pre = " + pre);
        System.out.println("cur = " + cur);
        System.out.println();

        for (int i = m; i <= n; i++) {

            // 未翻转部分
            ListNode temp = cur.next;
            System.out.println("1：temp = " + temp);

            // 抠掉要提到前面去的节点
            cur.next = temp.next;
            System.out.println("2：cur = " + cur);
            System.out.println("2：pre = " + pre);

            temp.next = pre.next;
            System.out.println("3：temp = " + temp);

            pre.next = temp;
            System.out.println("4：pre = " + pre);

            System.out.println();
        }
        return dummy.next;
    }

}
