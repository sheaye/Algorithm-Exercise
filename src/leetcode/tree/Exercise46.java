package leetcode.tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 * For example:
 * Given binary tree{3,9,20,#,#,15,7},
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its zigzag level order traversal as:
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 * confused what"{1,#,2,3}"means? > read more on how binary tree is serialized on OJ.
 * OJ's Binary Tree Serialization:
 * The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.
 * Here's an example:
 * 1
 * / \
 * 2   3
 * /
 * 4
 * \
 * 5
 * The above binary tree is serialized as"{1,2,3,#,#,4,#,#,5}".
 */
public class Exercise46 {

    public static void main(String[] args) {
        Exercise46 exe = new Exercise46();
        System.out.println(exe.zigzagLevelOrder(TreeNode.createTreeNode("3,9,20,#,#,15,7")).toString());
    }

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            ArrayList<Integer> item = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (leftToRight) {
                    item.add(node.val);
                } else {
                    item.add(0, node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(item);
            leftToRight = !leftToRight;
        }
        return result;
    }

}
