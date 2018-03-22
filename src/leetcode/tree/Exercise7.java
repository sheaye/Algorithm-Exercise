package leetcode.tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class Exercise7 {


    /**
     * Given a binary tree, return the preorder traversal of its nodes' values.
     * For example:
     * 1
     * \
     * 2
     * /
     * 3
     * return[1,2,3].
     * Note: Recursive solution is trivial, could you do it iteratively?
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return list;
    }

}
