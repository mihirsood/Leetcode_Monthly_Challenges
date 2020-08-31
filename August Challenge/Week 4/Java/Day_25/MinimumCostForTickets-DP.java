// Problem : https://leetcode.com/problems/minimum-cost-for-tickets/
// Solution:
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int last = days[days.length-1];
        int[] dp = new int[last+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int d : days){
            dp[d] = 0;
        }
        
        for(int i = 1 ; i<dp.length ;i++){
            if(dp[i]==Integer.MAX_VALUE){
                dp[i]=dp[i-1];
            }else{
                
                dp[i]=Math.min(dp[i-1] + costs[0],Math.min(dp[Math.max(0,i-7)]+costs[1],            dp[Math.max(0,i-30)]+costs[2]));
            }
        }
            
        return dp[last];
    }
}
