package leetcode.tree;

import common.TreeNode;

/**
 * Given two binary trees, write a function to check if they are equal or not.
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 */
public class Exercise49 {

    public static void main(String[] args) {

        final String x = "x";
        String y = "y";
        String z1 = "xy";
        String z2 = x + "y";
        String z3 = x + y;
        System.out.println(z1 == z2);
        System.out.println(z1 == z3);

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}
