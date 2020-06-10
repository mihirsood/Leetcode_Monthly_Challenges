//Problem:https://leetcode.com/problems/move-zeroes/
//Solution
class Solution {
    public void moveZeroes(int[] nums) {
        int p=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[p]=nums[i];
                p++;
            }
            
        }
        for(int i=p;i<nums.length;i++){
            nums[i]=0;
        }
    }
}
