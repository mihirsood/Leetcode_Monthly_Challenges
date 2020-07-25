// Problem : https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
// Solution:
class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int mid;
        while(left<right){
            while(left<nums.length-1 && nums[left]==nums[left+1]) left++;
            while(right>0 && nums[right]==nums[right-1]) right--;
            
            if(left>right) break;
            mid = left + (right-left)/2;
            if(nums[mid]>nums[right]) left = mid+1;
            else
                right=mid;
        }
        return nums[left];
    }
}
