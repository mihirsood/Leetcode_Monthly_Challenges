// Problem : https://leetcode.com/problems/house-robber-ii/
// Solution:

class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        
        return Math.max(calc(nums,0,nums.length-2),calc(nums,1,nums.length-1));
    }
    private int calc(int[] nums, int s, int e){
        if(s==e) return nums[s];
        int[] dp = new int[nums.length];
        dp[s]=nums[s];
        dp[s+1]=Math.max(nums[s+1],dp[s]);
        for(int i=s+2;i<=e;i++){
            dp[i]=Math.max(dp[i-2]+nums[i], dp[i-1]);
        }
        return dp[e];
    }
}