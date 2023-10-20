
/**
    You are given an array prices where prices[i] is the price of a given stock on the ith day.

    You want to maximize your profit by choosing a single day to buy one stock and choosing a
    different day in the future to sell that stock.

    Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

    Example 1:
        Input: prices = [7,1,5,3,6,4]
        Output: 5
        Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
        Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

    Example 2:
        Input: prices = [7,6,4,3,1]
        Output: 0
        Explanation: In this case, no transactions are done and the max profit = 0.

    Ref: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/?envType=study-plan-v2&envId=top-interview-150
*/

class Solution121 {

    public int maxProfit(int[] prices) {

        int length = prices.length;

        /**
            Here we have 2 locks to make to get the max profit.brute
            maxProfit is to make sure to obtain the overall max profit;
            minBuyPrice is to find the lowest by price, and use this to calculate the candidates of maxProfit.
        */
        int maxProfit = 0;
        int minBuyPrice = Integer.MAX_VALUE;

        // One-pass approach: O(n)
        for (int i=0; i < length; i++) {
            if (prices[i] < minBuyPrice) {
                minBuyPrice = prices[i];
            } else {
                maxProfit = java.lang.Math.max(maxProfit, prices[i] - minBuyPrice);
            }
        }

        return maxProfit;

    }

    public int maxProfit_brute(int[] prices) {

        int length = prices.length;
        int maxProfit = 0;
        int minBuyPrice = Integer.MAX_VALUE;

        /** brute force approach
         // Table
         //  b/s    day-1, day-2, day-3, day-4
         // day-1     0      x      x      x
         // day-2     -      0      x      x
         // day-3     -      -      0      x
         // day-4     -      -      -      0
        */

        for (int i=0; i < length-1; i++) {
            for (int j=i+1; j < length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }

        return maxProfit;
    }

}