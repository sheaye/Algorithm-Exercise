package offer66;

import common.ListNode;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class Exercise16 {

    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
//      使用第一个元素初始化mergedList
        ListNode mergedList;
        if (list1.val > list2.val) {
            mergedList = list2;
            list2 = list2.next;
        } else {
            mergedList = list1;
            list1 = list1.next;
        }
//      获取mergedList的尾节点
        ListNode node = mergedList;
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {// list2的当前元素更小时，将list2元素插入node尾部，并更新list2
                node.next = list2;
                list2 = list2.next;
            } else {// list1的当前元素不大于list1时，将list1元素插入node尾部，并更新list1
                node.next = list1;
                list1 = list1.next;
            }
            node = node.next;
        }
        if (list1 != null) {// 如果还有list1还有元素，接入list1
            node.next = list1;
        }
        if (list2 != null) {// 如果还有list2还有元素，接入list2
            node.next = list2;
        }
        return mergedList;
    }

    public ListNode Merge2(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val > list2.val) {
            list2.next = Merge2(list1, list2.next);
            return list2;
        } else {
            list1.next = Merge2(list1.next, list2);
            return list1;
        }
    }

    public static void main(String[] args) {
        ListNode list1 = ListNode.create(1, 3, 5, 7, 9);
        ListNode list2 = ListNode.create(2, 4, 6, 8, 10);
        Exercise16 exe = new Exercise16();
        ListNode mergedList = exe.Merge2(list1, list2);
        System.out.println(mergedList.toString());
    }

}
