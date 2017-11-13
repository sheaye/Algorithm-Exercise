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
        if (pre == null || in == null || pre.length == 0 || in.length == 0) {
            return null;
        }
        int element = pre[0];
        TreeNode node = new TreeNode(pre[0]);
        int targetIndex = getIndex(in, element);
        if (targetIndex > 0) {
            int leftCount = targetIndex;
            int[] leftPre = new int[leftCount];
            int[] leftIn = new int[leftCount];
            for (int i = 0; i < leftCount; i++) {
                leftPre[i] = pre[i + 1];
                leftIn[i] = in[i];
            }
            node.left = reConstructBinaryTree(leftPre, leftIn);

            int rightCount = in.length - leftCount - 1;
            int[] rightPre = new int[rightCount];
            int[] rightIn = new int[rightCount];
            for (int j = targetIndex + 1; j < in.length; j++) {
                rightPre[j] = pre[j];
                rightIn[j] = in[j];
            }
            node.right = reConstructBinaryTree(rightPre, rightIn);
        }
        return node;
    }

    public static int getIndex(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void prePrintTree(TreeNode tree) {
        if (tree != null) {
        }
    }

    public static void midPrintTree(TreeNode tree) {

    }

}
