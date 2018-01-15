package jianzhioffer;

import java.util.ArrayList;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class Exercise22 {

    public static void main(String[] args) {
        Exercise22 exe = new Exercise22();
        System.out.println(exe.PrintFromTopToBottom(TreeNode.createTreeNode()));
    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        collectElements(list,root);
        return list;
    }

    private void collectElements(ArrayList<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        collectElements(list,root.left);
        collectElements(list,root.right);
    }
}
