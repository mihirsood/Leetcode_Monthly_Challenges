//Problem:https://leetcode.com/explore/featured/card/june-leetcoding-challenge/540/week-2-june-8th-june-14th/3357/
//Solution

class Solution {
    public void sortColors(int[] nums) {
        /*Try moving all 0s to start and all 2s to the end and eventually all the 1s would end up in the mid
        Start keeps track of where 0s should be and End keeps track of where 2s should be
        Whenever we encounter a 0 we swap it with the element present at start as 0 should be at the starting*/
        
        int start=0;
        int end=nums.length-1;
        int in=0;
        
        while(in<=end && start < end ){
            if(nums[in]==0){
                nums[in]=nums[start];
                nums[start]=0;
                in++;
                start++;
            }
            else if(nums[in]==2){
                nums[in]=nums[end];
                nums[end]=2;
                end--;
                //we dont increment the index here as we have to check what the last element
            }else{
                in++;
            }
        }
    }
}
