package exercise;


public class Exercise15 {

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode inner;
        ListNode outer = new ListNode(head.val);
        while (head.next != null) {
            inner = outer;
            outer = new ListNode(head.next.val);
            outer.next = inner;
            head = head.next;
        }
        return outer;
    }

    public ListNode ReverseList2(ListNode head) {
        ListNode reversed = null;
        ListNode temp;
        int i = 0;
        while (head != null) {
            temp = head.next;
            head.next = reversed;
            reversed = head;
            head = temp;
        }
        return reversed;
    }

    public ListNode reverseList3(ListNode head) {
        ListNode pre = null;// 前半的已反转部分
        ListNode next;// 后半的待反转部分
        while (head != null) {
            next = head.next;// 备份待反转头部以下的部分
            head.next = pre;// 用已反转的部分替换掉待反转的头部以下部分，也就是将下一个待反转元素插入到已反转部分的头部，形成新的已反转部分。
            pre = head;// 将已反转部分交给reversed
            head = next;// 将剩余的待反转部分交给head，指针指向下一点，进入下一循环
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(0);
        ListNode temp = list;
        for (int i = 1; i < 10; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        Exercise15 exe = new Exercise15();
        ListNode reversedList = exe.ReverseList2(list);
        Exercise15.printListNode("reversedList", reversedList);
    }

    private static void printListNode(String tag, ListNode listNode) {
        System.out.print(tag + ": ");
        while (listNode != null) {
            System.out.print(listNode.val + ", ");
            listNode = listNode.next;
        }
        System.out.println();
    }

}
