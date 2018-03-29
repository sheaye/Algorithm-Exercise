package leetcode.tree;

import common.ProgramTimer;
import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * For example:
 * Given binary tree{1,#,2,3},
 * return[3,2,1].
 * Note: Recursive solution is trivial, could you do it iteratively?
 */
public class Exercise6 {

    public static void main(String[] args) {
        Exercise6 exe = new Exercise6();
        TreeNode tree = TreeNode.createTreeNode("1,#,2,3");
        ProgramTimer.timing("1:", 100000, new ProgramTimer.Runner() {
            @Override
            public void run() {
                exe.postorderTraversal(tree);
            }
        });
        ProgramTimer.timing("2:", 100000, new ProgramTimer.Runner() {
            @Override
            public void run() {
                exe.postorderTraversal2(tree);
            }
        });
        System.out.println(exe.postorderTraversal2(tree).toString());

    }

    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        postorderTraversal(list, root);
        return list;
    }

    private void postorderTraversal(ArrayList<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        postorderTraversal(list, root.left);
        postorderTraversal(list, root.right);
        list.add(root.val);
    }

    public LinkedList<Integer> postorderTraversal2(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
            list.push(node.val);
//            linkedlist.add(0, node.val);
        }
        return list;
    }

}
