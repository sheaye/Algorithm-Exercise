package leetcode.tree;

import common.TreeNode;

/**
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 */
public class Exercise1 {

    public int run(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMinDepth = run(root.left);
        int rightMinDepth = run(root.right);
        if (leftMinDepth == 0 || rightMinDepth == 0) {
            return leftMinDepth + rightMinDepth + 1;
        }
        return 1 + Math.min(leftMinDepth, rightMinDepth);
    }

    public int run2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left != null && root.right != null) {
            return Math.min(run2(root.left) + 1, run2(root.right) + 1);
        }
        if (root.left != null) {
            return run2(root.left) + 1;
        } else {
            return run2(root.right) + 1;
        }
    }


}
