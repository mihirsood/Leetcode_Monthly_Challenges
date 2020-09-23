// Problem : https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/
// Solution:

class Solution {
    public int findMaximumXOR(int[] nums) {
        int max=0;
        for(int s =0;s<nums.length-1;s++){
            for(int e=s+1;e<nums.length;e++){
                if((nums[s]^nums[e])>max){
                    max=nums[s]^nums[e];
                }
            }
        }
        return max;
    }
}
