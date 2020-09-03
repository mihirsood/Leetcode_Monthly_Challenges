// Problem : https://leetcode.com/problems/contains-duplicate-iii/
// Solution:

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> tset = new TreeSet<>();
        for(int i = 0;i<nums.length;i++){
            Long justsmaller = tset.floor((long)nums[i]);
            Long justlarger = tset.ceiling((long)nums[i]);
            
            if(justsmaller!=null && (long)nums[i]-justsmaller<=t){
                return true;
            }
            
            if(justlarger!=null && justlarger-(long)nums[i]<=t){
                return true;
            }
            
            tset.add((long)nums[i]);
            
            if(tset.size()>k){
                tset.remove((long)nums[i-k]);
            }
        }
        return false;
    }
}
