package jianzhioffer;

import java.util.ArrayList;

/**
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class Exercise24 {

    private ArrayList<ArrayList<Integer>> mResult = new ArrayList<>();
    private ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null || root.val > target) {
            return mResult;
        }
        list.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            mResult.add(new ArrayList<>(list));
        } else {
            if (root.left != null) {
                FindPath(root.left, target);
            }
            if (root.right != null) {
                FindPath(root.right, target);
            }
        }
        list.remove(list.size() - 1);
        return mResult;
    }


}
