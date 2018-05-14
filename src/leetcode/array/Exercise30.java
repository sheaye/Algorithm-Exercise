package leetcode.array;

/**
 * Say you have an array for which the i th element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction
 * (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 */
public class Exercise30 {

    public static void main(String[] args) {
        Exercise30 exe = new Exercise30();
        int[] array = {5, 10, 6, 13, 3, 5};
        System.out.println(exe.maxProfit(array));
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int buy = Integer.MIN_VALUE;
        int sell = 0;
        for (int i = 0; i < prices.length; i++) {
            buy = Math.max(buy, -prices[i]);
            sell = Math.max(sell, prices[i] + buy);
        }
        return sell;
    }

}
