package leetcode.tree;

import common.TreeNode;

import java.util.ArrayList;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * For example:
 * Given the below binary tree andsum = 22,
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * return
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 */
public class Exercise37 {

    public static void main(String[] args) {
        Exercise37 exe = new Exercise37();
        TreeNode treeNode = TreeNode.createTreeNode("-2,#,-3");
        ArrayList<ArrayList<Integer>> lists = exe.pathSum(treeNode, -5);
        for (ArrayList<Integer> list : lists) {
            System.out.println(list.toString());
        }
    }

    private ArrayList<ArrayList<Integer>> result;

    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        pathSum(root, sum, new ArrayList<>());
        return result;
    }

    private void pathSum(TreeNode node, int sum, ArrayList<Integer> list) {
        sum -= node.val;
        int curIndex = list.size();
        list.add(node.val);
        if (node.left == null && node.right == null) {
            if (sum == 0) {
                result.add(new ArrayList<>(list));
            }
        }else {
            if (node.left != null) {
                pathSum(node.left, sum, list);
            }
            if (node.right != null) {
                pathSum(node.right, sum, list);
            }
        }
        list.remove(curIndex);
    }

}
