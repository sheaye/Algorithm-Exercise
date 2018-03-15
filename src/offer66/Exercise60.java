package offer66;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class Exercise60 {

    public static void main(String[] args) {
        Exercise60 exe = new Exercise60();
        System.out.println(exe.Print(TreeNode.createTreeNode("1,2,3,4,5,6,7")).toString());
    }

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if (pRoot == null) {
            return lists;
        }
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(pRoot);
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            if (!queue1.isEmpty()) {
                transfer(queue1, queue2, lists);
            }
            if (!queue2.isEmpty()) {
                transfer(queue2, queue1, lists);
            }
        }
        return lists;
    }

    private void transfer(Queue<TreeNode> queue1, Queue<TreeNode> queue2, ArrayList<ArrayList<Integer>> lists) {
        ArrayList<Integer> list = new ArrayList<>();
        while (!queue1.isEmpty()) {
            TreeNode node = queue1.poll();
            if (node != null) {
                list.add(node.val);
                if (node.left != null) {
                    queue2.offer(node.left);
                }
                if (node.right != null) {
                    queue2.offer(node.right);
                }
            }
        }
        if (list.size() > 0) {
            lists.add(list);
        }
    }
}
