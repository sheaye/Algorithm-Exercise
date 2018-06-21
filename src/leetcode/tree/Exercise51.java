package leetcode.tree;

import common.TreeNode;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 */
public class Exercise51 {

    public static void main(String[] args) {
        Exercise51 exe = new Exercise51();
        System.out.println(exe.isValidBST(TreeNode.createTreeNode("10,5,15,#,#,6,20")));
    }

    private TreeNode pre;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (pre != null && root.val <= pre.val) {
            return false;
        }
        pre = root;
        return isValidBST(root.right);
    }

}
