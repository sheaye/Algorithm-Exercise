package aim_to_offer;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * 思路：
 * 1. 数组最后一个元素为根
 * 2. 二叉搜索树的左子树元素都小于根，其右子树元素都大于根
 * 3. 遍历数组找到第一个大于根元素的位置，它左边的数组就是左子树元素，剩下的除去根元素的部分是其右子树
 * 4. 遍历右子树，如果出现了小于根元素的树，则返回false.
 * 5. 递归判断左子树和右子树
 */
public class Exercise23 {

    public static void main(String[] args) {
        Exercise23 exe = new Exercise23();
        System.out.println(exe.VerifySquenceOfBST(new int[]{5, 4, 3, 2, 1}));
    }

    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null) {
            return false;
        }
        if (sequence.length < 1) {
            return false;
        }
        if (sequence.length == 1) {
            return true;
        }
        return VerifySquenceOfBST(sequence, 0, sequence.length - 1);
    }

    /**
     * 1. 数组最后一个元素为根
     * 2. 二叉搜索树的左子树元素都小于根，其右子树元素都大于根
     * 3. 遍历数组找到第一个大于根元素的位置，它左边的数组就是左子树元素，剩下的除去根元素的部分是其右子树
     * 4. 遍历右子树，如果出现了小于根元素的树，则返回false.
     * 5. 递归判断左子树和右子树
     */
    public boolean VerifySquenceOfBST(int[] sequence, int left, int right) {
        System.out.println("left = " + left + ", right = " + right);
        if (left >= right) {
            return true;
        }
        int root = sequence[right];
        int mid;
        for (int i = left; i < right - 1; i++) {
            if (sequence[i] > root) {
                mid = i - 1;
                for (int j = i + 1; j < right - 1; j++) {
                    if (sequence[j] < root) {
                        return false;
                    }
                }
                return VerifySquenceOfBST(sequence, left, mid) && VerifySquenceOfBST(sequence, mid + 1, right - 1);
            }
        }
        return true;
    }
}
