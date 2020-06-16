//Problem:https://leetcode.com/explore/featured/card/june-leetcoding-challenge/540/week-2-june-8th-june-14th/3357/
//Solution:

class Solution {
    public void sortColors(int[] nums) {
        int cr,cb,cw;
        cr=cb=cw=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                cr++;
            }
            else if(nums[i]==1){
                cw++;
            }
            else{
                cb++;
            }
        }
        int p=0;
        while(cr!=0){
            nums[p++]=0;
            cr--;
        }
        while(cw!=0){
            nums[p++]=1;
            cw--;
        }
        while(cb!=0){
            nums[p++]=2;
            cb--;
        }
    }
}
