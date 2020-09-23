// Problem : https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
// Solution:

class Solution {
    public int maxProfit(int[] prices) {
        int minsf=Integer.MAX_VALUE;
        int profit=0;
        for(int p:prices){
            if(p<minsf){
                minsf=p;
            }
            int cp = p-minsf;
            if(cp>profit){
                profit=cp;
            }
        }
        return profit;
    }
}
