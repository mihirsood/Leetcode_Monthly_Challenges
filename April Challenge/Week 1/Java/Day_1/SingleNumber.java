//Problem: https://leetcode.com/problems/single-number/
//Solution: Hashmap
class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
           if(map.containsKey(nums[i])){
               map.put(nums[i],(map.get(nums[i])+1));
           }
           else{
              map.put(nums[i],1); 
           } 
        }
        
        for(int i=0;i<nums.length;i++){
            if(map.get(nums[i])==1){
            return nums[i];
            }
        }
        return -1;
    }
}
