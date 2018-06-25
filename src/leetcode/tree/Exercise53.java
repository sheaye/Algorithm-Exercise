package leetcode.tree;

import common.TreeNode;

import java.util.ArrayList;

/**
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 * For example,
 * Given n = 3, your program should return all 5 unique BST's shown below.
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 */
public class Exercise53 {

    public static void main(String[] args) {
        Exercise53 exe = new Exercise53();
        ArrayList<TreeNode> trees = exe.generateTrees(0);
        for (int i = 0; i < trees.size(); i++) {
            System.out.println(trees.get(i).toString());
        }
    }


    public ArrayList<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    private ArrayList<TreeNode> generateTrees(int left, int right) {
        ArrayList<TreeNode> result = new ArrayList<>();
        if (left > right) {
            result.add(null);
            return result;
        }
        for (int i = left; i < right + 1; i++) {
            ArrayList<TreeNode> leftTrees = generateTrees(left, i - 1);
            ArrayList<TreeNode> rightTrees = generateTrees(i + 1, right);
            for (int j = 0; j < leftTrees.size(); j++) {
                for (int k = 0; k < rightTrees.size(); k++) {
                    TreeNode tree = new TreeNode(i);
                    tree.left = leftTrees.get(j);
                    tree.right = rightTrees.get(k);
                    result.add(tree);
                }
            }
        }
        return result;
    }

    /*private ArrayList<TreeNode> generateTrees(int[] arr, int start, int end) {
        ArrayList<TreeNode> list = new ArrayList<>();
        if (start > end) {
            list.add(null);
            return list;
        }
        for (int i = start; i < end + 1; i++) {
            ArrayList<TreeNode> lefts = generateTrees(arr, start, i - 1);
            ArrayList<TreeNode> rights = generateTrees(arr, i + 1, end);
            if (lefts.size() < 1 && rights.size() < 1) {
                TreeNode node = new TreeNode(arr[i]);
                list.add(node);
                continue;
            }
            if (lefts.size() < 1) {
                for (TreeNode right : rights) {
                    TreeNode node = new TreeNode(arr[i]);
                    node.right = right;
                    list.add(node);
                }
                continue;
            }
            if (rights.size() < 1) {
                for (int j = 0; j < lefts.size(); j++) {
                    TreeNode node = new TreeNode(arr[i]);
                    node.left = lefts.get(j);
                    list.add(node);
                }
                continue;
            }
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode node = new TreeNode(arr[i]);
                    node.left = left;
                    node.right = right;
                    list.add(node);
                }
            }
        }
        return list;
    }*/


}
