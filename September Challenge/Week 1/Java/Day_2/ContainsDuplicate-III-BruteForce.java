// Problem : https://leetcode.com/problems/contains-duplicate-iii/
// Solution:

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for(int i = 0; i<nums.length;i++){
            for(int j = i+1; j<nums.length;j++){
                if((j-i)>k) break;
                if(Math.abs((long)nums[j]-(long)nums[i])<=(long)t){
                    return true;
                }
            }
        }
        return false;
    }
}
