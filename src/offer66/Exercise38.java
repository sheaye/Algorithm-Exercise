package offer66;

import common.ProgramTimer;
import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class Exercise38 {

    public static void main(String[] args) {
        Exercise38 exe = new Exercise38();
        int times = Integer.MAX_VALUE;
        //95846 millions
        ProgramTimer.timing("递归：", times, () -> exe.TreeDepth(TreeNode.createTreeNode()));
        //240362 millions
        ProgramTimer.timing("队列遍历：", times, () -> exe.TreeDepth2(TreeNode.createTreeNode()));
        System.out.println(exe.TreeDepth2(TreeNode.createTreeNode()));

    }

    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(TreeDepth(root.left), TreeDepth(root.right)) + 1;
    }

    public int TreeDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0, count = 0, nextCount = 1;
        while (!queue.isEmpty()) {
            count++;
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
            if (count == nextCount) {
                nextCount = queue.size();
                count = 0;
                depth++;
            }
        }
        return depth;
    }
}
