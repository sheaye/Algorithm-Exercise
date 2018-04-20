package leetcode.tree;

import common.TreeNode;

/**
 * Given a binary tree containing digits from0-9only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path1->2->3which represents the number123.
 * Find the total sum of all root-to-leaf numbers.
 * For example,
 * 1
 * / \
 * 2   3
 * The root-to-leaf path1->2represents the number12.
 * The root-to-leaf path1->3represents the number13.
 * Return the sum = 12 + 13 =25.
 */
public class Exercise22 {

    public static void main(String[] args) {
        Exercise22 exe = new Exercise22();
        System.out.println(exe.sumNumbers(TreeNode.createTreeNode("9")));
    }

    public int sumNumbers(TreeNode root) {
        int sum = 0;
        return preOrder(root, sum);
    }

    private int preOrder(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }
        return preOrder(root.left, sum) + preOrder(root.right, sum);
    }

}
