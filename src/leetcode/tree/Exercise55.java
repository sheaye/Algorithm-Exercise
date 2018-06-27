package leetcode.tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * For example:
 * Given binary tree{1,#,2,3},
 * 1
 * \
 * 2
 * /
 * 3
 * return[1,3,2].
 * Note: Recursive solution is trivial, could you do it iteratively?
 */
public class Exercise55 {

    public static void main(String[] args) {
        Exercise55 exe = new Exercise55();
        System.out.println(exe.inorderTraversal(TreeNode.createTreeNode("1,#,2,3")).toString());
    }

    private ArrayList<Integer> mResult = new ArrayList<>();

    public ArrayList<Integer> inorderTraversal2(TreeNode root) {
        if (root == null) {
            return mResult;
        }
        inorderTraversal2(root.left);
        mResult.add(root.val);
        inorderTraversal2(root.right);
        return mResult;
    }

    // Morris遍历
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        while (root != null) {
            // 中序遍历中当前节点root的前一节点的初始化
            TreeNode pre = root.left;
            // 如果当前节点root的左子树为null:添加root值到list中，当前节点遍历到右节点或者线索的下一节点
            if (pre == null) {
                result.add(root.val);
                root = root.right;
                continue;
            }
            // root左子树不为null：找到当前节点root的上一节点，即左子树的最右节点
            while (pre.right != null && pre.right != root) {
                pre = pre.right;
            }
            // 如果root上一节点pre没有线索化：加线索，当前节点root遍历进入root左子树
            if (pre.right == null) {
                pre.right = root;
                root = root.left;
            } else {// 如果root上一节点pre已经线索化，去线索，添加root值到list中，当前节点遍历进入右子树
                pre.right = null;
                result.add(root.val);
                root = root.right;
            }

        }
        return result;
    }

    public ArrayList<Integer> inorderTraversal1(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }
}
