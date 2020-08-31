// Problem : https://leetcode.com/problems/minimum-cost-for-tickets/
// Solution:
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int last = days[days.length-1];
        int[] dp = new int[last+1];
        
        int index = 0;
        for(int i = 1 ; i<dp.length ;i++){
            if(i == days[index]){
                dp[i]=Math.min(dp[i-1] + costs[0], Math.min(dp[Math.max(0,i-7)]+costs[1], dp[Math.max(0,i-30)]+costs[2]));
                index++;
            }
            else{
                dp[i]=dp[i-1];
            }
        }
            
        return dp[last];
    }
}
