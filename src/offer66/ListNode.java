package offer66;

public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ListNode)) {
            return false;
        }
        ListNode node2 = (ListNode) obj;
        if (node2.val != this.val) {
            return false;
        }
        if (this.next == null) {
            return node2.next == null;
        } else {
            return next.equals(node2.next);
        }

    }

    public String toString() {
        ListNode listNode = this;
        StringBuilder builder = new StringBuilder("{ ");
        while (listNode != null) {
            builder.append(listNode.val + ", ");
            listNode = listNode.next;
        }
        builder.delete(builder.lastIndexOf(", "), builder.length());
        return builder.append(" }").toString();
    }

    public static ListNode create(int... array) {
        if (array == null || array.length < 1) {
            return null;
        }
        ListNode list = new ListNode(array[0]);
        ListNode node = list;
        for (int i = 1; i < array.length; i++) {
            node.next = new ListNode(array[i]);
            node = node.next;
        }
        return list;
    }
}
