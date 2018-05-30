package leetcode.tree;

import common.TreeNode;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class Exercise41 {

    public TreeNode sortedArrayToBST(int[] num) {
        if (num == null || num.length < 1) {
            return null;
        }
        return sortedArrayToBST(num, 0, num.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] num, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right + 1) >> 1;
        TreeNode node = new TreeNode(num[mid]);
        node.left = sortedArrayToBST(num, left, mid - 1);
        node.right = sortedArrayToBST(num, mid + 1, right);
        return node;
    }

}
