package note.tree;

public class Test {

    public static void main(String[] args) {
        Test test = new Test();
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        boolean isLeftThread;
        boolean isRightThread;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.val);
        inOrder(node.right);
    }

    private TreeNode mPreNode;

    public void inThreadOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inThreadOrder(node.left);
        if (node.left == null) {
            node.left = mPreNode;
            node.isLeftThread = true;
        }
        if (mPreNode != null && mPreNode.right == null) {
            mPreNode.right = node;
            mPreNode.isRightThread = true;
        }
        mPreNode = node;
        inThreadOrder(node.right);
    }

}
