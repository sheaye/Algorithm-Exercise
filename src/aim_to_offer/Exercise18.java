package aim_to_offer;

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

    public static void main(String[] args) {
        TreeNode tree = TreeNode.createTreeNode();
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
