package leetcode.array;

/**
 * Say you have an array for which the i th element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit.
 * You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times).
 * However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class Exercise29 {

    public static void main(String[] args) {
        Exercise29 exe = new Exercise29();
        int[] array = {5, 10, 6, 13, 3, 5};
        System.out.println(exe.maxProfit(array));
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i - 1] > 0) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }

    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length < 1) {
            return 0;
        }
        int profit = 0;
        int buy = Integer.MIN_VALUE;
        int sell = 0;

        for (int i = 0; i < prices.length; i++) {
            buy = Math.max(buy, -prices[i]);
            if (buy + prices[i] < sell) {
                profit += sell;
                buy = -prices[i];
                sell = 0;
            } else {
                sell = buy + prices[i];
            }
        }
        int last = buy + prices[prices.length - 1];
        return profit + (last > 0 ? last : 0);

    }

}
