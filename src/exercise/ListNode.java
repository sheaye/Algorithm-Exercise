package exercise;

public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
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
