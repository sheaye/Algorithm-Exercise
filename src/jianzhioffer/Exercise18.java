package jianzhioffer;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 二叉树的镜像定义：源二叉树
 * 8
 * /  \
 * 6   10
 * / \  / \
 * 5  7 9 11
 * <p>
 * 镜像二叉树
 * 8
 * /  \
 * 10   6
 * / \  / \
 * 11 9 7  5
 */
public class Exercise18 {

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

    public static void main(String[] args) {
        TreeNode tree = createTreeNode();
        System.out.println(tree.toString());
        Mirror(tree);
        System.out.println(tree.toString());
    }

    public static void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }
        Mirror(root.left);
        TreeNode temp = root.left;
        Mirror(root.right);
        root.left = root.right;
        root.right = temp;
    }
}
