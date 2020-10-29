// Problem : https://leetcode.com/problems/jump-game/
// Solution:

class Solution {
    public boolean canJump(int[] nums) {
        int max =0;
        int n=nums.length-1;
        
        for(int i=0;i<n;i++){
            if(i>max){
                return false;
            }
            max=Math.max(max,i+nums[i]);
            if(max>=n) 
                break;
        }
        return max>=n;
    }
}
