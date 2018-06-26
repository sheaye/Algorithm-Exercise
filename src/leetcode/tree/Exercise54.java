package leetcode.tree;

import java.util.HashMap;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 * For example,
 * Given n = 3, there are a total of 5 unique BST's.
 */
public class Exercise54 {

    public static void main(String[] args) {
        Exercise54 exe = new Exercise54();
        System.out.println(exe.numTrees(4));
    }

    public int numTrees2(int n) {
        map.put(0, 1);
        return numTrees(1, n);
    }

    private HashMap<Integer, Integer> map = new HashMap<>();

    private int numTrees(int left, int right) {
        if (left > right) {
            return 1;
        }
        if (map.containsKey(right - left)) {
            return map.get(right - left);
        }
        int sum = 0;
        for (int i = left; i < right + 1; i++) {
            sum += numTrees(left, i - 1) * numTrees(i + 1, right);
        }
        map.put(right - left, sum);
        return sum;
    }

    public int numTrees(int n) {
        // 用dp[i]表示1-i可组成的二叉搜索树的数量
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];

    }

}
