// Problem : https://leetcode.com/problems/k-diff-pairs-in-an-array/
// Solution:

class Solution {
    public int findPairs(int[] nums, int k) {
        int res=0;
        int s=0;
        int f=1;
        Arrays.sort(nums);
        while(s<nums.length && f<nums.length){
            if((f<nums.length)&&(nums[f]-nums[s]==k)){
                res++;
                s++;
                while(s<nums.length && nums[s]==nums[s-1]){
                    s++;
                }
            }else if(s<nums.length && nums[f]-nums[s]>k){
                s++;
                while(s<nums.length && nums[s]==nums[s-1]){
                    s++;
                }
            }else{
                f++;
            }
            if(s>=f) 
                f=s+1;
        }
        return res;
    }
}