package leetcode.array;

import java.util.HashMap;

/**
 * Say you have an array for which the i th element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class Exercise28 {

    public static void main(String[] args) {
        int[] arr = {5, 7, 2, 12, 5, 20, 35};
        Exercise28 exe = new Exercise28();
        System.out.println(exe.maxProfit(arr));
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int buy1 = Integer.MIN_VALUE;
        int sel1 = 0;
        int buy2 = Integer.MIN_VALUE;
        int sel2 = 0;
        for (int i = 0; i < prices.length; i++) {
            buy1 = Math.max(-prices[i], buy1);// 一次性买入的最低点
            sel1 = Math.max(sel1, buy1 + prices[i]);//一次性买入的最高点，sel1为一次性买入所得的最高利润
            buy2 = Math.max(buy2, sel1 - prices[i]);//一次性卖出之后，找到的第二买点，buy2
            sel2 = Math.max(sel2, buy2 + prices[i]);//第二次卖出
            System.out.println("buy1 = " + buy1 + ", sel1 = " + sel1 + ", buy2 = " + buy2 + ", sel2 = " + sel2);
        }
        return sel2;

    }

    public int maxProfit2(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            int value = leftMax(prices, i) + rightMax(prices, i + 1);
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    private HashMap<Integer, Integer> leftMap = new HashMap<>();

    private int leftMax(int[] prices, int right) {
        if (leftMap.containsKey(right)) {
            return leftMap.get(right);
        }
        if (right <= 0) {
            leftMap.put(right, 0);
            return 0;
        }
        int max = leftMax(prices, right - 1);
        for (int i = 0; i < right; i++) {
            int value = prices[right] - prices[i];
            if (max < value) {
                max = value;
            }
        }
        leftMap.put(right, max);
        return max;
    }

    private HashMap<Integer, Integer> rightMap = new HashMap<>();

    private int rightMax(int[] prices, int left) {
        if (rightMap.containsKey(left)) {
            return rightMap.get(left);
        }
        if (left >= prices.length - 1) {
            rightMap.put(left, 0);
            return 0;
        }
        int max = rightMax(prices, left + 1);
        for (int i = left + 1; i < prices.length; i++) {
            int value = prices[i] - prices[left];
            if (max < value) {
                max = value;
                rightMap.put(left, max);
            }
        }
        return max;
    }


}
