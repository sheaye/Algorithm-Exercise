package common;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {

    public int val = 0;
    public TreeNode left = null;
    public TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }

    /**
     * 8
     * /  \
     * 6   10
     * / \  / \
     * 5  7 9 11
     */
    public static TreeNode createTreeNode() {
        TreeNode tree = new TreeNode(8);
        tree.left = new TreeNode(6);
        tree.left.left = new TreeNode(5);
        tree.left.right = new TreeNode(7);

        tree.right = new TreeNode(10);
        tree.right.left = new TreeNode(9);
        tree.right.right = new TreeNode(11);
        return tree;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (left != null) {
            builder.append(left.toString());
        }
        builder.append(val).append(", ");
        if (right != null) {
            builder.append(right.toString());
        }
        return builder.toString();
    }


    public static TreeNode createTreeNode(String str) {
        if (str == null || str.length() < 1) {
            return null;
        }
        String[] strs = str.split(",");
        TreeNode tree = new TreeNode(Integer.parseInt(strs[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(tree);
        int i = 1;
        while (!queue.isEmpty()) {
            if (i == strs.length) {
                break;
            }
            TreeNode node = queue.poll();
            String leftStr = strs[i++];
            if (!leftStr.equals("#")) {
                node.left = new TreeNode(Integer.parseInt(leftStr));
                queue.offer(node.left);
            } else {
                node.left = null;
            }
            if (i == strs.length) {
                break;
            }
            String rightStr = strs[i++];
            if (!rightStr.equals("#")) {
                node.right = new TreeNode(Integer.parseInt(rightStr));
                queue.offer(node.right);
            } else {
                node.right = null;
            }

        }
        return tree;
    }

    public static void main(String[] args) {
        TreeNode tree = TreeNode.createTreeNode("8,6,10,5,#,9,11");
//        TreeNode tree = TreeNode.createTreeNode();
        System.out.println(tree.toString());
    }
}
