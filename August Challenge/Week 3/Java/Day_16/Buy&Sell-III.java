// Problem : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
// Solution:

class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length==0) return 0;
        int msf = prices[0];
        int[] left = new int[prices.length];
        
        for(int i=1;i<prices.length;i++){
            if(prices[i]<msf){
                msf=prices[i];
            }
            int curr = prices[i]-msf;
            left[i]=Math.max(curr,left[i-1]);
        }
        
        int maxat = prices[prices.length-1];
        int[] right = new int[prices.length];

        for(int i = prices.length-2;i>=0;i--){
            if(prices[i]>maxat){
                maxat=prices[i];
            }
            int curr = maxat - prices[i];
            right[i]=Math.max(curr,right[i+1]);
        }
        int op = 0;
        for(int i=0;i<prices.length;i++){
            if(op<left[i]+right[i]){
                op = left[i]+right[i];
            }
        }
        return op;
        
    }
}
