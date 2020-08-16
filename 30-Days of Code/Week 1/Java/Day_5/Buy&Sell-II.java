// Problem : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
// Solution:
class Solution {
    public int maxProfit(int[] prices) {
        int sd=0;
        int bd=0;
        int profit=0;
        for(int i = 1;i<prices.length;i++){
            if(prices[i]>=prices[i-1]){
                sd++;
            }else{
                profit+=prices[sd]-prices[bd];
                bd=sd=i;
            }
        }
        profit+=prices[sd]-prices[bd];
        return profit;
    }
}
