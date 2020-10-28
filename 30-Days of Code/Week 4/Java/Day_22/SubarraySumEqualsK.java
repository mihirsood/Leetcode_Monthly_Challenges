// Problem : https://leetcode.com/problems/subarray-sum-equals-k/
// Solution:

class Solution {
    public int subarraySum(int[] nums, int k) {
        int count=0;
        for(int s=0;s<nums.length;s++){
            int sum=0;
            for(int e=s;e<nums.length;e++){
                sum+=nums[e];
                
                if(sum==k)
                    count++;
            }
        }
        return count;
    }
}
