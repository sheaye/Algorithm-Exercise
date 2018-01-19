package aim_to_offer;

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
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] mid = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode tree = reConstructBinaryTree(pre, mid);
        prePrintTree(tree);
        System.out.println();
        midPrintTree(tree);
    }

    /**
     * 思路：使用前序数组中的元素对中序数组进行分割，该元素将数组分为左支和右支，自身为节点值
     */
    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length == 0 || in.length == 0) {
            return null;
        }
        int element = pre[0];
        TreeNode node = new TreeNode(pre[0]);
        if (pre.length > 1) {
            int targetIndex = getIndex(in, element);
            int leftCount = targetIndex;
            int[] leftPre = new int[leftCount];
            int[] leftIn = new int[leftCount];
            for (int i = 0; i < leftCount; i++) {
                leftPre[i] = pre[i + 1];
                leftIn[i] = in[i];
            }
            node.left = reConstructBinaryTree(leftPre, leftIn);
            int rightCount = in.length - leftCount - 1;
            if (rightCount > 0) {
                int[] rightPre = new int[rightCount];
                int[] rightIn = new int[rightCount];
                for (int j = 0; j < rightCount; j++) {
                    rightPre[j] = pre[j + targetIndex + 1];
                    rightIn[j] = in[j + targetIndex + 1];
                }
                node.right = reConstructBinaryTree(rightPre, rightIn);
            }
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
            System.out.print(tree.val);
            prePrintTree(tree.left);
            prePrintTree(tree.right);
        }
    }

    public static void midPrintTree(TreeNode tree) {
        if (tree != null) {
            midPrintTree(tree.left);
            System.out.print(tree.val);
            midPrintTree(tree.right);
        }
    }

}
