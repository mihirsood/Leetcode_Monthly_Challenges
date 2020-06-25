// Problem:https://leetcode.com/problems/find-the-duplicate-number/
//Solution:
class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length ;
        int curr = 0;
        int max = 0;
        
        for(int i = 0; i < n ; i++){
            int idx = nums[i]%n;
            nums[idx]+=n;
        }
        
        for(int i = 0; i < n ; i++ ){
            if(nums[i]>curr){
                curr = nums[i];
                max = i ;
            }
        }
        
        return max;
    }
}
