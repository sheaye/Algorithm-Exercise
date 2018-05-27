package leetcode.tree;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 * For example:
 * Given the below binary tree andsum = 22,
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \      \
 * 7    2      1
 * return true, as there exist a root-to-leaf path5->4->11->2which sum is 22.
 */
public class Exercise38 {

    public static void main(String[] args) {
        Exercise38 exe = new Exercise38();
        System.out.println(exe.hasPathSum2(TreeNode.createTreeNode("5,4,8,11,#,13,4,7,2,#,#,#,1"), 22));
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0) {
            return true;
        }
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }

    public boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> sumQueue = new LinkedList<>();
        nodeQueue.add(root);
        sumQueue.add(sum);
        while (!nodeQueue.isEmpty()) {
            TreeNode curNode = nodeQueue.poll();
            int curSum = sumQueue.poll() - curNode.val;
            if (curNode.left == null && curNode.right == null && curSum == 0) {
                return true;
            }
            if (curNode.left != null) {
                nodeQueue.add(curNode.left);
                sumQueue.add(curSum);
            }
            if (curNode.right != null) {
                nodeQueue.add(curNode.right);
                sumQueue.add(curSum);
            }
        }
        return false;
    }


}
