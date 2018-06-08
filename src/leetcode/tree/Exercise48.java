package leetcode.tree;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * For example, this binary tree is symmetric:
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * But the following is not:
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
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
public class Exercise48 {

    public static void main(String[] args) {
        Exercise48 exe = new Exercise48();
        System.out.println(exe.isSymmetric(TreeNode.createTreeNode("1,2,2,3,4,4,3")));
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);

    }

    private boolean isSymmetric(TreeNode leftTree, TreeNode rightTree) {
        if (leftTree == null && rightTree == null) {
            return true;
        }
        if (leftTree == null) {
            return false;
        }
        if (rightTree == null) {
            return false;
        }
        if (leftTree.val != rightTree.val) {
            return false;
        }
        return isSymmetric(leftTree.left, rightTree.right) && isSymmetric(leftTree.right, rightTree.left);
    }

    public boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> leftQueue = new LinkedList<>();
        Queue<TreeNode> rightQueue = new LinkedList<>();
        leftQueue.offer(root.left);
        rightQueue.offer(root.right);
        while (!leftQueue.isEmpty()) {
            int leftSize = leftQueue.size();
            int rightSize = rightQueue.size();
            if (leftSize != rightSize) {
                return false;
            }
            for (int i = 0; i < leftSize; i++) {
                TreeNode leftNode = leftQueue.poll();
                TreeNode rightNode = rightQueue.poll();
                if (leftNode == null && rightNode == null) {
                    continue;
                }
                if (leftNode == null) {
                    return false;
                }
                if (rightNode == null) {
                    return false;
                }
                if (leftNode.val != rightNode.val) {
                    return false;
                }

                leftQueue.offer(leftNode.left);
                leftQueue.offer(leftNode.right);

                rightQueue.offer(rightNode.right);
                rightQueue.offer(rightNode.left);

            }
        }
        return rightQueue.isEmpty();
    }


}
