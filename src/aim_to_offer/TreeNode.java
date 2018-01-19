package aim_to_offer;

public class TreeNode {

    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }

    /**
     *      8
     *    /  \
     *   6   10
     *  / \  / \
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
        builder.append(val).append(", ");
        if (left != null) {
            builder.append(left.toString());
        }
        if (right != null) {
            builder.append(right.toString());
        }
        return builder.toString();
    }
}
