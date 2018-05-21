package leetcode.tree;

import common.TreeLinkNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 * What if the given tree could be any binary tree? Would your previous solution still work?
 * Note:
 * You may only use constant extra space.
 * For example,
 * Given the following binary tree,
 * 1
 * /  \
 * 2    3
 * / \    \
 * 4   5    7
 * After calling your function, the tree should look like:
 * 1 -> NULL
 * /  \
 * 2 -> 3 -> NULL
 * / \    \
 * 4-> 5 -> 7 -> NULL
 */
public class Exercise34 {

    public void connect2(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.add(root);
        int levelSize = 1;
        TreeLinkNode pre = null;
        while (!queue.isEmpty()) {
            while (levelSize-- != 0) {
                TreeLinkNode node = queue.poll();
                if (pre != null) {
                    pre.next = node;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                pre = node;
            }
            pre = null;
            levelSize = queue.size();
        }
    }


    public void connect(TreeLinkNode root) {
        while (root != null) {
            TreeLinkNode curLevel = new TreeLinkNode(-1);
            TreeLinkNode prev = curLevel;
            // 将node所在一层的下一层节点从左到右串联起来
            for (TreeLinkNode node = root; node != null; node = node.next) {
                if (node.left != null) {
                    prev.next = node.left;
                    prev = prev.next;
                }
                if (node.right != null) {
                    prev.next = node.right;
                    prev = prev.next;
                }
            }
            // 遍历到下一层
            root = curLevel.next;
        }
    }

}
