package offer66;

public class Exercise36 {

    public static void main(String[] args) {
        Exercise36 exe = new Exercise36();
        System.out.println(exe.FindFirstCommonNode2(ListNode.create(1, 2, 3, 4, 5, 6, 7, 8), ListNode.create(5, 6, 7, 8)));
    }

    /**
     * 输入两个链表，找出它们的第一个公共结点。
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        if (pHead1.val == pHead2.val) {
            return pHead1;
        }
        ListNode node1 = pHead1;
        int minIndex = Integer.MAX_VALUE;
        ListNode minNode = null;
        int i = 0;
        while (node1 != null && i < minIndex) {
            int j = 0;
            ListNode node2 = pHead2;
            while (node2 != null && j < minIndex) {
                if (node1.val == node2.val) {
                    minIndex = Math.max(i, j);
                    minNode = node2;
                }
                j++;
                node2 = node2.next;
            }
            i++;
            node1 = node1.next;
        }
        return minNode;
    }

    public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (!equals(p1, p2)) {
            p1 = (p1 == null ? pHead2 : p1.next);
            p2 = (p2 == null ? pHead1 : p2.next);
        }
        return p1;
    }

    private boolean equals(ListNode node1, ListNode node2) {
        if (node1 == null) {
            return node2 == null;
        }
        return node2 != null &&
                node1.val == node2.val &&
                equals(node1.next, node2.next);
    }
}


