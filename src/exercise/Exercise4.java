package exercise;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * <p>
 * 提示：
 * 前序遍历：print(tree.value),print(tree.left),print(tree.right)
 * 中序遍历：print(tree.left),print(tree.value),print(tree.right)
 * 后续遍历：print(tree.left),print(tree.right),print(tree.value)
 */
public class Exercise4 {

    public static void main(String[] args) {

    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode root = new TreeNode(pre[0]);
        TreeNode temp = root;
        for (int i = 0, j = 0; i < in.length; i++) {
            for (; j < pre.length; j++) {
                if (pre[j] != in[i]) {
                    temp.left = new TreeNode(pre[j]);
                    temp = root.left;
                } else {
                    break;
                }
            }
        }
        return null;
    }



}
