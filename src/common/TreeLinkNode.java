package common;

import java.util.LinkedList;
import java.util.Queue;

public class TreeLinkNode {

    int val;
    public TreeLinkNode left = null;
    public TreeLinkNode right = null;
    public TreeLinkNode next = null;

    public TreeLinkNode(int val) {
        this.val = val;
    }

    public static TreeLinkNode createTreeNode(String str) {
        if (str == null || str.length() < 1) {
            return null;
        }
        String[] strs = str.split(",");
        TreeLinkNode tree = new TreeLinkNode(Integer.parseInt(strs[0]));
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.add(tree);
        int i = 1;
        while (!queue.isEmpty()) {
            if (i == strs.length) {
                break;
            }
            TreeLinkNode node = queue.poll();
            String leftStr = strs[i++];
            if (!leftStr.equals("#")) {
                node.left = new TreeLinkNode(Integer.parseInt(leftStr));
                queue.offer(node.left);
            } else {
                node.left = null;
            }
            if (i == strs.length) {
                break;
            }
            String rightStr = strs[i++];
            if (!rightStr.equals("#")) {
                node.right = new TreeLinkNode(Integer.parseInt(rightStr));
                queue.offer(node.right);
            } else {
                node.right = null;
            }

        }
        return tree;
    }
}
