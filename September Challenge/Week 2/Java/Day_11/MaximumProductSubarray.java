// Problem : https://leetcode.com/problems/maximum-product-subarray/
// Solution:

class Solution {
    public int maxProduct(int[] nums) {
        int max=nums[0];
        int min=nums[0];
        int ans=nums[0];
        for(int i=1;i<nums.length;i++){
            int curr_max = Math.max(Math.max(max*nums[i],min*nums[i]),nums[i]);
            int curr_min = Math.min(Math.min(max*nums[i],min*nums[i]),nums[i]);
            
            ans=Math.max(curr_max,ans);
            max=curr_max;
            min=curr_min;
        }
        
        return ans;
    }
}
