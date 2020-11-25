// Problem : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
// Solution:

class Solution {
    public int maxProfit(int k, int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int len = prices.length;
        if (k >= len / 2) {
            return allProfit(prices);
        }   
        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];
        Arrays.fill(buy, Integer.MIN_VALUE);
        for (int i = 0; i < len; i++) {    
            for (int trans = 1; trans <= k; trans++) {
                buy[trans] = Math.max(sell[trans - 1] - prices[i], buy[trans]);
                sell[trans] = Math.max(buy[trans] + prices[i], sell[trans]);
            }   
        }
        return sell[k];
    }
    
    public int allProfit(int[] prices) {
        int result = 0;
        for (int i = 1; i < prices.length;  i++) {
            int diff = prices[i] - prices[i - 1];
            if (diff > 0) result += diff;
        }
        return result;
       
    }
}