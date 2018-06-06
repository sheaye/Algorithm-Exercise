package leetcode.tree;

import common.TreeNode;

/**
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class Exercise45 {

    public static void main(String[] args) {
        Exercise45 exe = new Exercise45();
        System.out.println(exe.maxDepth(TreeNode.createTreeNode("1,2,3,4,5,6,7,#,#,8,9,#,#,#,#,#,#")));
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

}
