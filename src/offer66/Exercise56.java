package offer66;

import common.ListNode;

/**
 * 复的在一个排序的链表中，存在重复的结点，请删除该链表中重结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class Exercise56 {

    public static void main(String[] args) {
        Exercise56 exe = new Exercise56();
        ListNode list = ListNode.create(1, 1, 1, 1, 1, 1, 2);
        ListNode list2 = exe.deleteDuplication(list);
        System.out.println(list2 != null ? list2.toString() : "{}");
    }


    //*******************优解*****************
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) { // 只有0个或1个结点，则返回
            return pHead;
        }
        if (pHead.val == pHead.next.val) { // 当前结点是重复结点
            ListNode pNode = pHead.next;
            while (pNode != null && pNode.val == pHead.val) {
                // 跳过值与当前结点相同的全部结点,找到第一个与当前结点不同的结点
                pNode = pNode.next;
            }
            return deleteDuplication(pNode); // 从第一个与当前结点不同的结点开始递归
        } else { // 当前结点不是重复结点
            pHead.next = deleteDuplication(pHead.next); // 保留当前结点，从下一个结点开始递归
            return pHead;
        }
    }

    //    *******************我的解*****************
    private ListNode result;
    private ListNode current;

    public ListNode deleteDuplication2(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        deleteDuplication(pHead, pHead.next);
        return result;
    }

    private void deleteDuplication(ListNode n0, ListNode n1) {
        if (n1 == null) {
            if (current != null) {
                current.next = n0;
            } else {
                result = n0;
            }
            return;
        }
        if (n0.val == n1.val) {
            while (n1 != null && n0.val == n1.val) {
                n1 = n1.next;
            }
            if (n1 == null) {
                if (current != null) {
                    current.next = null;
                }
                return;
            }
            deleteDuplication(n1, n1.next);
        } else {
            if (result == null) {
                result = n0;
                current = result;
            } else {
                current.next = n0;
                current = current.next;
            }
            deleteDuplication(n1, n1.next);
        }
    }


}
