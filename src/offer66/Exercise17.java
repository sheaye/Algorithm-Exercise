package offer66;

import common.TreeNode;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class Exercise17 {

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        return isSubtree(root1, root2) ||
                isSubtree(root1.left, root2) ||
                isSubtree(root1.right, root2);
    }

    public boolean isSubtree(TreeNode tree1, TreeNode tree2) {
        if (tree2 == null) {
            return true;
        }
        if (tree1 == null) {
            return false;
        }
        if (tree1.val == tree2.val) {
            return isSubtree(tree1.left, tree2.left) &&
                    isSubtree(tree1.right, tree2.right);
        } else {
            return false;
        }
    }
}
