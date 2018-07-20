package leetcode.linkedlist;

import common.ListNode;

/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * For example,
 * Given1->4->3->2->5->2 and x = 3,
 * return1->2->2->4->3->5.
 */
public class Exercise63 {

    public static void main(String[] args) {
        Exercise63 exe = new Exercise63();
        System.out.println(exe.partition(ListNode.create(1, 4, 3, 2, 5, 2), 3).toString());
        System.out.println(exe.partition(null, 3));
        System.out.println(exe.partition(ListNode.create(2, 1), 2));
        System.out.println(exe.partition(ListNode.create(1, 1), 2));
    }

    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        // 寻找比x小的淘客
        ListNode taoke = head;
        // 淘客前面的节点
        ListNode pre = dummy;
        // 负责整理的整理员
        ListNode arranger = dummy;

        while (taoke != null) {
            if (taoke.val < x) {
                if (pre.val < x) {// 如果pre值比x小,无需变换
                    pre = taoke;
                } else {
                    // 先把taoke从原链表中抽出来
                    pre.next = taoke.next;
                    // 再把taoke插到前面去
                    taoke.next = arranger.next;
                    arranger.next = taoke;
                }
                // 把arrager遍历到下一位
                arranger = arranger.next;
                // 把taoke遍历到下一位，pre不用动
                taoke = pre.next;
            } else {
                // taoke继续往下淘
                pre = taoke;
                taoke = taoke.next;
            }
        }
        return dummy.next;

    }

}
