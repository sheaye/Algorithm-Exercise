package jianzhioffer;

public class TreeNode {

    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

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
