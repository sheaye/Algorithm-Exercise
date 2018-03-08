package offer66;

/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 测试用例：{1,2,3,4,5,#,6,#,#,7}
 */
public class Exercise39 {

    public static void main(String[] args) {
        Exercise39 exe = new Exercise39();
        System.out.print(exe.IsBalanced_Solution(TreeNode.createTreeNode()));
    }

    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(treeHeight(root.left) - treeHeight(root.right)) < 2 && IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }

    private int treeHeight(TreeNode tree) {
        if (tree == null) {
            return 0;
        }
        if (tree.left == null && tree.right == null) {
            return 1;
        }
        return Math.max(treeHeight(tree.left), treeHeight(tree.right)) + 1;
    }

    private boolean isBalanced = true;

    public boolean IsBalanced_Solution2(TreeNode tree) {
        if (tree == null) {
            return true;
        }
        getDepth(tree);
        return isBalanced;
    }

    private int getDepth(TreeNode tree) {
        if (tree == null) {
            return 0;
        }
        int left = getDepth(tree.left);
        int right = getDepth(tree.right);
        if (Math.abs(left - right) > 1) {
            isBalanced = false;
        }
        return right > left ? right + 1 : left + 1;
    }

}
