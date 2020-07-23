// Problem :https://leetcode.com/problems/single-number-iii/
// Solution:
class Solution {
    public int[] singleNumber(int[] nums) {
        
        int diff=nums[0];
        
        for(int i=1;i<nums.length;i++) 
            //XOR All the numbers, the numbers occuring twice will cancel out
            diff^=nums[i];
        
        diff&=-diff; // Find the last set bit 
        
        int[] result ={0,0};
        
        for(int i:nums){
            
            if((i&diff)==0) // Bit is set
                result[0]^=i;
            
            else    // Bit is not set
                result[1]^=i;
        }
        
        return result;
    }
}
