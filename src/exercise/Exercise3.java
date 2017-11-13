package exercise;

import java.util.ArrayList;

/**
 * 输入一个链表，从尾到头打印链表每个节点的值。
 */
public class Exercise3 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(0);
        ListNode node = listNode;
        int i = 1;
        while (i < 10) {
            node.next = new ListNode(i);
            i++;
            node = node.next;
        }
        System.out.print(printListFromTailToHead(listNode));
    }


    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


    public static ArrayList<Integer> reverseList(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if (listNode == null) {
            return list;
        }
        do {
            list.add(listNode.val);
            listNode = listNode.next;
        } while (listNode != null);
        for (int i = 0, j = list.size() - 1; i < j; i++, j--) {
            Integer temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
        }
        return list;
    }

    public static ArrayList<Integer> printListFromTailToHead(ListNode n) {
        ArrayList<Integer> al = new ArrayList<>();
        func(al, n);
        return al;

    }

    public static void func(ArrayList<Integer> al, ListNode n) {
        if (n != null) {
            func(al, n.next);
            al.add(n.val);
        }
    }

}
