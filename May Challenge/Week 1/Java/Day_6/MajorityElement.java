// Problem : https://leetcode.com/problems/majority-element/
// Solution:

class Solution {
    public int majorityElement(int[] nums) {
        int num = 0;
        int count=0;
        for(int i =0;i<nums.length;i++){
            if(nums[i]==num) count++;
            else if(count==0){
                num=nums[i];
                count=1;
            }else{
                count--;
            }
        }
        return num;
    }
}
