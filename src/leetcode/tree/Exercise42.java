package leetcode.tree;

import common.ProgramTimer;
import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 * For example:
 * Given binary tree{3,9,20,#,#,15,7},
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its bottom-up level order traversal as:
 * [
 * [15,7]
 * [9,20],
 * [3],
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
public class Exercise42 {

    public static void main(String[] args) {
        Exercise42 exe = new Exercise42();
        ProgramTimer.timing("LinkedList", 1000, new ProgramTimer.Runner() {
            @Override
            public void run() {
                exe.levelOrderBottom(TreeNode.createTreeNode("3,9,20,#,#,15,7,5,6,7,8,9,3,5,9,1,2,5,7,8,9,5,8,3,9,2,7,4,9,10,11,12,13,16,17,3,9,20,#,#,15,7,5,6,7,8,9,3,5,9,1,2,5,7,8,9,5,8,3,9,2,7,4,9,10,11,12,13,16,17,3,9,20,#,#,15,7,5,6,7,8,9,3,5,9,1,2,5,7,8,9,5,8,3,9,2,7,4,9,10,11,12,13,16,17,3,9,20,#,#,15,7,5,6,7,8,9,3,5,9,1,2,5,7,8,9,5,8,3,9,2,7,4,9,10,11,12,13,16,17,3,9,20,#,#,15,7,5,6,7,8,9,3,5,9,1,2,5,7,8,9,5,8,3,9,2,7,4,9,10,11,12,13,16,17,3,9,20,#,#,15,7,5,6,7,8,9,3,5,9,1,2,5,7,8,9,5,8,3,9,2,7,4,9,10,11,12,13,16,17,3,9,20,#,#,15,7,5,6,7,8,9,3,5,9,1,2,5,7,8,9,5,8,3,9,2,7,4,9,10,11,12,13,16,17,3,9,20,#,#,15,7,5,6,7,8,9,3,5,9,1,2,5,7,8,9,5,8,3,9,2,7,4,9,10,11,12,13,16,17,3,9,20,#,#,15,7,5,6,7,8,9,3,5,9,1,2,5,7,8,9,5,8,3,9,2,7,4,9,10,11,12,13,16,17,3,9,20,#,#,15,7,5,6,7,8,9,3,5,9,1,2,5,7,8,9,5,8,3,9,2,7,4,9,10,11,12,13,16,17,3,9,20,#,#,15,7,5,6,7,8,9,3,5,9,1,2,5,7,8,9,5,8,3,9,2,7,4,9,10,11,12,13,16,17,3,9,20,#,#,15,7,5,6,7,8,9,3,5,9,1,2,5,7,8,9,5,8,3,9,2,7,4,9,10,11,12,13,16,17,"));
            }
        });
        ProgramTimer.timing("ArrayList", 1000, new ProgramTimer.Runner() {
            @Override
            public void run() {
                exe.levelOrderBottom2(TreeNode.createTreeNode("3,9,20,#,#,15,7,5,6,7,8,9,3,5,9,1,2,5,7,8,9,5,8,3,9,2,7,4,9,10,11,12,13,16,17,3,9,20,#,#,15,7,5,6,7,8,9,3,5,9,1,2,5,7,8,9,5,8,3,9,2,7,4,9,10,11,12,13,16,17,3,9,20,#,#,15,7,5,6,7,8,9,3,5,9,1,2,5,7,8,9,5,8,3,9,2,7,4,9,10,11,12,13,16,17,3,9,20,#,#,15,7,5,6,7,8,9,3,5,9,1,2,5,7,8,9,5,8,3,9,2,7,4,9,10,11,12,13,16,17,3,9,20,#,#,15,7,5,6,7,8,9,3,5,9,1,2,5,7,8,9,5,8,3,9,2,7,4,9,10,11,12,13,16,17,3,9,20,#,#,15,7,5,6,7,8,9,3,5,9,1,2,5,7,8,9,5,8,3,9,2,7,4,9,10,11,12,13,16,17,3,9,20,#,#,15,7,5,6,7,8,9,3,5,9,1,2,5,7,8,9,5,8,3,9,2,7,4,9,10,11,12,13,16,17,3,9,20,#,#,15,7,5,6,7,8,9,3,5,9,1,2,5,7,8,9,5,8,3,9,2,7,4,9,10,11,12,13,16,17,3,9,20,#,#,15,7,5,6,7,8,9,3,5,9,1,2,5,7,8,9,5,8,3,9,2,7,4,9,10,11,12,13,16,17,3,9,20,#,#,15,7,5,6,7,8,9,3,5,9,1,2,5,7,8,9,5,8,3,9,2,7,4,9,10,11,12,13,16,17,3,9,20,#,#,15,7,5,6,7,8,9,3,5,9,1,2,5,7,8,9,5,8,3,9,2,7,4,9,10,11,12,13,16,17,3,9,20,#,#,15,7,5,6,7,8,9,3,5,9,1,2,5,7,8,9,5,8,3,9,2,7,4,9,10,11,12,13,16,17,"));
            }
        });
        System.out.println(exe.levelOrderBottom(TreeNode.createTreeNode("3,9,20,#,#,15,7")).toString());
    }

    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        LinkedList<ArrayList<Integer>> linkedResult = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int size = 1;
        while (!queue.isEmpty()) {
            ArrayList<Integer> item = new ArrayList<>();
            while (size-- != 0) {
                TreeNode node = queue.poll();
                item.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add((node.right));
                }
            }
            linkedResult.addFirst(item);
            size = queue.size();
        }
        return new ArrayList<>(linkedResult);
    }

    public ArrayList<ArrayList<Integer>> levelOrderBottom2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int size = 1;
        while (!queue.isEmpty()) {
            ArrayList<Integer> item = new ArrayList<>();
            while (size-- != 0) {
                TreeNode node = queue.poll();
                item.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add((node.right));
                }
            }
            result.add(0,item);
            size = queue.size();
        }
        return result;
    }



}
