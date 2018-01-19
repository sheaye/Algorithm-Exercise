package aim_to_offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * 8
 * /  \
 * 6   10
 * / \  / \
 * 5  7 9 11
 */
public class Exercise22 {

    public static void main(String[] args) {
        Exercise22 exe = new Exercise22();
        System.out.println(exe.PrintFromTopToBottom(TreeNode.createTreeNode()));
    }

    public ArrayList<Integer> PrintFromTopToBottom2(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        collectElements(list, root);
        return list;
    }

    private void collectElements(ArrayList<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        collectElements(list, root.left);
        collectElements(list, root.right);
    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if (root == null) {
            return null;
        }
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            list.add(node.val);
        }
        return list;
    }
}
