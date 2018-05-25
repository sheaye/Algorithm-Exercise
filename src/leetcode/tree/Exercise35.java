package leetcode.tree;

import common.TreeLinkNode;

/**
 * Given a binary tree
 * struct TreeLinkNode {
 * TreeLinkNode *left;
 * TreeLinkNode *right;
 * TreeLinkNode *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set toNULL.
 * Initially, all next pointers are set toNULL.
 * Note:
 * You may only use constant extra space.
 * You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
 * For example,
 * Given the following perfect binary tree,
 * 1
 * /  \
 * 2    3
 * / \  / \
 * 4  5  6  7
 * After calling your function, the tree should look like:
 * 1 -> NULL
 * /  \
 * 2 -> 3 -> NULL
 * / \  / \
 * 4->5->6->7 -> NULL
 */
public class Exercise35 {

    public static void main(String[] args) {
        TreeLinkNode tree = TreeLinkNode.createTreeNode("1,2,3");
        Exercise35 exe = new Exercise35();
        exe.connect2(tree);
    }

    public void connect2(TreeLinkNode root) {
        while (root != null) {
            TreeLinkNode temp = new TreeLinkNode(-1);
            TreeLinkNode node = temp;
            while (root != null) {
                if (root.left != null) {
                    node.next = root.left;
                    node = node.next;
                }
                if (root.right != null) {
                    node.next = root.right;
                    node = node.next;
                }
                root = root.next;
            }
            root = temp.next;
        }
    }

}
