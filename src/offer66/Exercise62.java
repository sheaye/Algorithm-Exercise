package offer66;

/**
 * 给定一颗二叉搜索树，请找出其中的第k大的结点。
 * 例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，按结点数值大小顺序第三个结点的值为4。
 */
public class Exercise62 {

    public static void main(String[] args) {
        Exercise62 exe = new Exercise62();
        System.out.println(exe.KthNode(TreeNode.createTreeNode("5,3,7,2,4,6,8"),3));
    }

    private int current;

    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null) {
            return null;
        }
        TreeNode result = KthNode(pRoot.left, k);
        if (result != null) {
            return result;
        }
        current++;
        if (current == k) {
            return pRoot;
        }
        result = KthNode(pRoot.right, k);
        if (result != null) {
            return result;
        }
        return null;
    }
}
