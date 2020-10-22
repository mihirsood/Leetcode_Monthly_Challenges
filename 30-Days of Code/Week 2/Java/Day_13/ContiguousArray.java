// Problem : https://leetcode.com/problems/contiguous-array/
// Solution:

class Solution {
    public int findMaxLength(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)
                nums[i]=-1;
        }
        
        HashMap<Integer,Integer> map = new HashMap<>(); // sum to idx
        map.put(0,-1);//0 sum at idx -1
        int sum=0;
        int max=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(map.containsKey(sum)){
                max=Math.max(max,i-map.get(sum));
            }else{
                map.put(sum,i);
            }
        }
        return max;
    }
}
