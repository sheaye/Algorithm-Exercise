package leetcode.tree;

import common.TreeNode;

/**
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which
 * the depth of the two subtrees of every node never differ by more than 1.
 */
public class Exercise39 {

    public static void main(String[] args) {
        Exercise39 exe = new Exercise39();
        System.out.println(exe.isBalanced(TreeNode.createTreeNode("1,2")));
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isBalanced(root.left) && isBalanced(root.right) && (Math.abs(depth(root.left) - depth(root.right)) <= 1);
    }

    private int depth(TreeNode tree) {
        if (tree == null) {
            return 0;
        }
        return Math.max(depth(tree.left), depth(tree.right)) + 1;

    }

    public boolean isBalanced2(TreeNode root) {
        if (root == null) {
            return true;
        }
        return getHeight(root) != -1;
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getHeight(root.left);
        if (left < 0) {
            return -1;
        }
        int right = getHeight(root.right);
        if (right < 0) {
            return -1;
        }
        if (Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }


}
