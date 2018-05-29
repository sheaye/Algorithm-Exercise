package leetcode.tree;

import common.ListNode;
import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class Exercise40 {

    public static void main(String[] args) {
        Exercise40 exe = new Exercise40();
        System.out.println(exe.sortedListToBST(ListNode.create(1, 3)).toString());
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return sortedListToBST(list, 0, list.size() - 1);
    }

    private TreeNode sortedListToBST(List<Integer> list, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right + 1) / 2;
        TreeNode node = new TreeNode(list.get(mid));
        node.left = sortedListToBST(list, left, mid - 1);
        node.right = sortedListToBST(list, mid + 1, right);
        return node;
    }


}
